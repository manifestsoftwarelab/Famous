package com.example.pb221.vendaq.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.AllDataCallback;
import com.example.pb221.vendaq.main.DatabaseHelper;
import com.example.pb221.vendaq.main.IAllDataObserver;
import com.example.pb221.vendaq.main.MyApplication;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.main.utils.WebServiceCall;
import com.example.pb221.vendaq.main.BaseActivity;
import com.example.pb221.vendaq.product.productmodel.OutletsPOJONew;
import com.example.pb221.vendaq.product.productmodel.ProductPOJONew;

import org.json.JSONArray;
import org.json.JSONObject;


import static com.example.pb221.vendaq.main.utils.Utils.TABLE_OUTLETS_DETAILS;
import static com.example.pb221.vendaq.main.utils.Utils.TABLE_PRODUCT_LIST;
import static com.example.pb221.vendaq.main.utils.Utils.TABLE_PRODUCT_TYPE;
import static com.example.pb221.vendaq.main.utils.Utils.TABLE_SUPPLIER_DETAILS;
import static com.example.pb221.vendaq.main.utils.Utils.TABLE_TAGS;
import static com.example.pb221.vendaq.main.utils.Utils.TABLE_TAX_DETAILS;
import static com.example.pb221.vendaq.main.utils.Utils.TABLE_VARIENTS_DETAILS;
import static com.example.pb221.vendaq.main.utils.Utils.getBrands;
import static com.example.pb221.vendaq.main.utils.Utils.getProducts;
import static com.example.pb221.vendaq.main.utils.Utils.getSuppliers;
import static com.example.pb221.vendaq.main.utils.Utils.getTags;
import static com.example.pb221.vendaq.main.utils.Utils.getTypes;
import static com.example.pb221.vendaq.main.utils.Utils.loginUrl;

/**
 * Created by pb221 on 29-10-2017.
 */

public class LoginActivity extends BaseActivity implements IAllDataObserver {
    private Button btnLogin;
    private EditText edtPassword;
    DatabaseHelper DB;
    private String result;
    String product_id;
    private EditText edtUserName;
    private EditText edtCompany;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_screen);

        initview();
        DB = MyApplication.getInstance(this);
      //  sendJsonToWebService(edtUserName.getText().toString(), edtPassword.getText().toString(), "koncept_kkd");

//        Intent sInt = new Intent(LoginActivity.this, MainActivity.class);
//        startActivity(sInt);
//        finish();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                String company =  edtCompany.getText().toString();
                if (!username.equals("") && !password.equals("")) {
                    sendJsonToWebService(edtUserName.getText().toString(), edtPassword.getText().toString(), "koncept_kkd");

                } else
                    Toast.makeText(LoginActivity.this, "Company , Username and Password fields cannot be blank",
                            Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initview() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtCompany = (EditText) findViewById(R.id.companyEditText);
    }

    private void sendJsonToWebService(String username, String password, String storeName) {
        showDelayIndicator();
        JSONObject job = new JSONObject();
        try {
            job.put(getResources().getString(R.string.str_key_username), username);
            job.put(getResources().getString(R.string.str_key_password), password);
            job.put(getResources().getString(R.string.str_key_storename), storeName);

            new WebServiceCall(LoginActivity.this).execute(loginUrl, job.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDataAvailable(String data) {


        Log.e("**result**", data + "");
        try {
            JSONObject job = new JSONObject(data);

            String isError = job.getString("IsError");
            if (isError.equalsIgnoreCase("0")) {
                updateUI();
            }
            else
            {
                edtCompany.setText("");
                edtUserName.setText("");
                edtPassword.setText("");
                hideDelayIndicator();
                String errorMessage = job.getString("ErrorMessage");
                Toast.makeText(LoginActivity.this, errorMessage,
                        Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updateUI() {
        try {
            JSONObject jobType = new JSONObject();
            JSONObject myJob;

            result = WebCallFragment.execute(getTypes, jobType.toString());
            {
                Log.e("**getType**", "" + result);
                if (checkIsError(result)) {
                    myJob = new JSONObject(result);
                    JSONArray jarr = myJob.getJSONArray("Result");
                    JSONObject innerJob = null;

                    DB.deleteFromTable(TABLE_PRODUCT_TYPE);
                    for (int i = 0; i < jarr.length(); i++) {
                        innerJob = jarr.getJSONObject(i);

                        DB.insertIntoProductType(
                                innerJob.getString("ProducttypeId"),
                                innerJob.getString("TypeName"),
                                innerJob.getString("NumberOfProducts")
                        );
                    }

                }


            }
            JSONObject jobTags = new JSONObject();
            result = WebCallFragment.execute(getTags, jobTags.toString());
            {
                Log.e("**getTags**", "" + result);

                if (checkIsError(result)) {
                    myJob = new JSONObject(result);

                    JSONArray jarr = myJob.getJSONArray("Result");
                    JSONObject innerJob = null;

                    DB.deleteFromTable(TABLE_TAGS);
                    for (int i = 0; i < jarr.length(); i++) {
                        innerJob = jarr.getJSONObject(i);

                        DB.insertIntoTags(
                                innerJob.getString("ProductTagId"),
                                innerJob.getString("ProductTagName"),
                                innerJob.getString("NumberOfProducts")
                        );

                    }
                }
            }
            JSONObject jobSupplier = new JSONObject();
            jobSupplier.put(getResources().getString(R.string.str_key_storeid), "1");


            result = WebCallFragment.execute(getSuppliers, jobSupplier.toString());
            {
                Log.e("**getSuppliers**", "" + result);

                if (checkIsError(result)) {
                    myJob = new JSONObject(result);


                    JSONArray jarr = myJob.getJSONArray("Result");
                    JSONObject innerJob = null;

                    DB.deleteFromTable(TABLE_SUPPLIER_DETAILS);
                    for (int i = 0; i < jarr.length(); i++) {
                        innerJob = jarr.getJSONObject(i);

                        DB.insertIntoSupplier(
                                innerJob.getString("SupplierId"),
                                innerJob.getString("SupplierName"),
                                innerJob.getString("SupplierEmail"),
                                innerJob.getString("SupplierPhone"),
                                innerJob.getString("Supplieraddress"),
                                innerJob.getString("DefaultMarkup"),
                                innerJob.getString("Description"),
                                innerJob.getString("NumberOfProducts")
                        );

                    }
                }
            }
            JSONObject jobBrand = new JSONObject();
            jobBrand.put(getResources().getString(R.string.str_key_categoryid), "4");

            result = WebCallFragment.execute(getBrands, jobBrand.toString());
            {
                Log.e("**getBrands**", "" + result);

                if (checkIsError(result)) {
                    myJob = new JSONObject(result);

                    JSONArray jarr = myJob.getJSONArray("Result");
                    JSONObject innerJob = null;

                    DB.deleteFromBrand();
                    for (int i = 0; i < jarr.length(); i++) {
                        innerJob = jarr.getJSONObject(i);

                        DB.insertIntoBrand(
                                innerJob.getString("BrandId"),
                                innerJob.getString("BrandName"),
                                innerJob.getString("BrandDescription"),
                                innerJob.getString("NumberOfProducts")

                        );
                    }
                }
            }

            result = WebCallFragment.execute(getProducts, jobBrand.toString());

            final JSONObject jobe = new JSONObject();
            JSONObject myjoba = new JSONObject();

            jobe.put(getResources().getString(R.string.str_key_store_id), "1");


            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(getProducts, jobe.toString());
                Log.e("**result IN pd*", result + "");

            }

            if (checkIsError(result)) {
                myjoba = new JSONObject(result);
//            getAllProductListDetails

                JSONArray jarr = myjoba.getJSONArray("Result");
                JSONObject innerJob = null;
                JSONObject outletJob = null;

                DB.deleteFromTable(TABLE_PRODUCT_LIST);
                DB.deleteFromTable(TABLE_OUTLETS_DETAILS);
                DB.deleteFromTable(TABLE_TAX_DETAILS);
                DB.deleteFromTable(TABLE_VARIENTS_DETAILS);

                for (int i = 0; i < jarr.length(); i++) {
                    innerJob = jarr.getJSONObject(i);

                    product_id = innerJob.getString("Pid");

                    DB.insertIntoProductList(product_id,
                            innerJob.getString("Name"),
                            innerJob.getString("brandid"),
                            innerJob.getString("brand"),
                            innerJob.getString("handle"),
                            innerJob.getString("description"),
                            innerJob.getString("tags"),
                            innerJob.getString("isSellable"),
                            innerJob.getString("SKU"),
                            innerJob.getString("supplierCode"),
                            innerJob.getString("supplier"),
                            innerJob.getString("Supplyprice"),
                            innerJob.getString("userid"),
                            innerJob.getString("IsInventory"),
                            innerJob.getString("Markup"),
                            innerJob.getString("Count"),
                            innerJob.getString("CreatedDate"));

                    JSONArray jarrOutlets = innerJob.getJSONArray("Outlets");


                    for (int j = 0; j < jarrOutlets.length(); j++) {

                        outletJob = jarrOutlets.getJSONObject(j);
                        DB.insertIntoOutlets(product_id,
                                outletJob.getString("OutletName")
                                , outletJob.getString("CurrentInventory")
                                , outletJob.getString("ReOrderPoint")
                                , outletJob.getString("ReOrderQuantity"));

                    }


                    JSONArray jarrTax = innerJob.getJSONArray("Tax");

                    for (int j = 0; j < jarrTax.length(); j++) {

                        outletJob = jarrTax.getJSONObject(j);

                        DB.insertIntoTax(product_id,
                                outletJob.getString("Outlet"),
                                outletJob.getString("Tax"));
                    }

                    JSONArray jarrVarients = innerJob.getJSONArray("Varients");

                    for (int j = 0; j < jarrVarients.length(); j++) {

                        outletJob = jarrVarients.getJSONObject(j);
                        DB.insertIntoVarient(product_id,
                                outletJob.getString("VariantName"),
                                outletJob.getString("VariantCount"),
                                outletJob.getString("SupplierCode"),
                                outletJob.getString("SupplierPrice"),
                                outletJob.getString("RetailPrice"));
                    }

                }


//                DB.insertIntoProductList(pid, Name, brandid, brand, handle, description,
//                        tags, isSellable, SKU, supplierCode, supplier, Supplyprice,
//                        userid, IsInventory, Markup, Count, CreatedDate);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        hideDelayIndicator();
        Intent sInt = new Intent(this, MainActivity.class);
        startActivity(sInt);
        finish();


    }

    public boolean checkIsError(String data) {
        boolean noError = false;
        try {
            JSONObject job = new JSONObject(data);

            String isError = job.getString("IsError");
            if (isError.equalsIgnoreCase("0")) {
                noError = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return noError;
    }

    @Override
    public void onDataAvailableAll(String allData) {

    }
}
