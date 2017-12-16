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

import org.json.JSONArray;
import org.json.JSONObject;


import static com.example.pb221.vendaq.main.utils.Utils.getBrands;
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
    private EditText edtUserName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_screen);

        initview();
        DB = MyApplication.getInstance(this);
        sendJsonToWebService(edtUserName.getText().toString(), edtPassword.getText().toString(), "koncept_kkd");


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if (!username.equals("") && !password.equals("")) {
                    sendJsonToWebService(edtUserName.getText().toString(), edtPassword.getText().toString(), "koncept_kkd");

                } else
                    Toast.makeText(LoginActivity.this, "username and password fields cannot be blank",
                            Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initview() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        hideDelayIndicator();

        Intent sInt = new Intent(LoginActivity.this, MainActivity.class);
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
