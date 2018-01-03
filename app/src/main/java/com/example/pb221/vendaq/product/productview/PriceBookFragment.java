package com.example.pb221.vendaq.product.productview;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.example.pb221.vendaq.main.BaseFragment;
import com.example.pb221.vendaq.main.utils.Utils.*;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pb221.vendaq.main.DatabaseHelper;
import com.example.pb221.vendaq.main.MyApplication;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.PriceBookAdapter;
import com.example.pb221.vendaq.product.productmodel.OutletsPOJONew;
import com.example.pb221.vendaq.product.productmodel.PriceBooksPOJO;
import com.example.pb221.vendaq.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_CREATED_AT;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_CUSTOMER_GROUP;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_OUTLET;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_PRICEBOOK_ID;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_PRICEBOOK_NAME;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_VALID_FROM;
import static com.example.pb221.vendaq.main.utils.Utils.COLUMN_VALID_TO;
import static com.example.pb221.vendaq.main.utils.Utils.TABLE_PRICEBOOK_LIST;
import static com.example.pb221.vendaq.main.utils.Utils.addPriceBook;
import static com.example.pb221.vendaq.main.utils.Utils.getPriceBook;

/**
 * Created by pb221 on 29-10-2017.
 */

public class PriceBookFragment extends BaseFragment {

    public PriceBookAdapter priceBookAdapter;
    public String result = "";
    DatabaseHelper DB;


    String customerGroup;
    String customerOutlet;

    private List<PriceBooksPOJO> priceBookList;
    private Button btnAddPriceBook;
    private RecyclerView recyclerViewProductList;
    final Calendar calender = Calendar.getInstance();
    EditText edtValidFrom;
    EditText edtValidTo;
    EditText activeEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_price_books, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        btnAddPriceBook = (Button) v.findViewById(R.id.btnAddPriceBook);
        getActivity().setTitle("Price Books");
        DB = MyApplication.getInstance(getActivity());


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;


        priceBookList = new ArrayList<>();

        getPriceBook();

/* product adapter list*/

/*
        PriceBooksPOJO priceBookPOJO1 = new PriceBooksPOJO("General Price Book(All Products)", "All Customers", "All Outlet", "12/08/2017", "12/09/2017", "27 Sep 2017 1:47 pm");
        PriceBooksPOJO priceBookPOJO2 = new PriceBooksPOJO("General Price Book(All Products)", "All Customers", "All Outlet", "12/08/2017", "12/09/2017", "27 Sep 2017 1:47 pm");
        PriceBooksPOJO priceBookPOJO3 = new PriceBooksPOJO("General Price Book(All Products)", "All Customers", "All Outlet", "12/08/2017", "12/09/2017", "27 Sep 2017 1:47 pm");

        priceBookList.add(priceBookPOJO1);
        priceBookList.add(priceBookPOJO2);
        priceBookList.add(priceBookPOJO3);


        priceBookAdapter = new PriceBookAdapter(priceBookList, getActivity());
        recyclerViewProductList.setAdapter(priceBookAdapter);
*/

        btnAddPriceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getActivity());
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_new_price_book);
                // Set dialog title
                dialog.setTitle("New Price Book");

                dialog.getWindow().setLayout((5 * width) / 7, (3 * height) / 5);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);


                final EditText edtPriceBook = (EditText) dialog.findViewById(R.id.edtPriceBook);
                edtValidFrom = (EditText) dialog.findViewById(R.id.edtValidFrom);
                edtValidTo = (EditText) dialog.findViewById(R.id.edtValidTo);

                final Spinner spCustomerGroup = (Spinner) dialog.findViewById(R.id.spCustomerGroup);
                final Spinner spCustomerOutlet = (Spinner) dialog.findViewById(R.id.spCustomerOutlet);

                Button btnCancelPricebook = (Button) dialog.findViewById(R.id.btnCancelPricebook);
                Button btnAddPricebook = (Button) dialog.findViewById(R.id.btnAddPricebook);

                final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkBox);

                edtValidFrom.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        activeEditText = edtValidFrom;
                        new DatePickerDialog(getActivity(), date, calender
                                .get(Calendar.YEAR), calender.get(Calendar.MONTH),
                                calender.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });
                edtValidTo.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        activeEditText = edtValidTo;
                        new DatePickerDialog(getActivity(), date, calender
                                .get(Calendar.YEAR), calender.get(Calendar.MONTH),
                                calender.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });

                btnAddPricebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = edtPriceBook.getText().toString();
                        String validFrom = edtValidFrom.getText().toString();
                        String validTo = edtValidTo.getText().toString();
                        String customerGroup = spCustomerGroup.getSelectedItem().toString();
                        String outlet = spCustomerOutlet.getSelectedItem().toString();
                        Boolean isInStore = checkBox.isChecked();

                        if ((name != null && !name.isEmpty()) && (validFrom != null && !validFrom.isEmpty()) && (validTo != null && !validTo.isEmpty()) && (customerGroup != null && !customerGroup.isEmpty()) && (outlet != null && !outlet.isEmpty()))

                        sendJsonToWebService(name, validFrom, validTo, customerGroup, outlet, isInStore);
                        dialog.dismiss();
                    }
                });
                btnCancelPricebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                String[] values = {"All Customers"};

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spCustomerGroup.setAdapter(adapter);

                List<OutletsPOJONew> outletList = DB.getAllOutletsInProductList("");
                ArrayList<String> outletNameArray = new ArrayList<String>();
                for(OutletsPOJONew outletPOJO : outletList)
                {outletNameArray.add(outletPOJO.getOutletName());}

                ArrayAdapter<String> outletAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, outletNameArray);
                outletAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spCustomerOutlet.setAdapter(outletAdapter);


                spCustomerGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spCustomerOutlet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                // set values for custom dialog components - text, image and button

                dialog.show();
            }
        });
        /* product adapter list*/


        return v;
    }

    public void updateUI() {

        Toast.makeText(getActivity(), "Pricebook Added Successfully", Toast.LENGTH_SHORT).show();
        getPriceBook();
    }

    public void getDataFromActivity(String data) {
        Log.e("**IN pricebOOK**", data + "");
        try {
            JSONObject job = new JSONObject(data);

            String isError = job.getString("IsError");
            if (isError.equalsIgnoreCase("0")) {
                updateUI();
            } else
                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sendJsonToWebService(String priceBookName, String priceBookValidFrom, String priceBookValidTo, String customerGroup, String customerOutlet, Boolean isInStore) {

        final JSONObject job = new JSONObject();

        try {
            job.put("pricebookname", priceBookName);
            job.put("customer_group", customerGroup);
            job.put("outlet", customerOutlet);
            job.put("ValidFrom", priceBookValidFrom);
            job.put("ValidTo", priceBookValidTo);
            job.put("IsInstore", isInStore.toString());
            job.put("store_id", "1");
            job.put("user_id", "1");

            Log.e("**json obj***", job.toString());
/*

            "IsInstore":"true",
                    "user_id":"true",
                    "store_id": "true"*/


            if (android.os.Build.VERSION.SDK_INT > 9) {
                result = WebCallFragment.execute(addPriceBook, job.toString());
                Log.e("**result IN SU*", result + "");
            }

            getDataFromActivity(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getPriceBook()
    {
        showDelayIndicator();
        final JSONObject job = new JSONObject();

        try {
            job.put("user_id", "1");

            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(getPriceBook, job.toString());
                Log.e("**result IN SU*", result + "");

            }
            getDataFromPriceBook(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDataFromPriceBook(String data) {
        Log.e("**result IN Tags**", data + "");
        try {
            JSONObject job = new JSONObject(data);

            String isError = job.getString("IsError");
            if (isError.equalsIgnoreCase("0")) {
                updatePriceBookUI(job);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updatePriceBookUI(JSONObject job) {
        try {
            JSONArray jarr = job.getJSONArray("Result");
            JSONObject innerJob = null;
            DB.deleteFromTable(TABLE_PRICEBOOK_LIST);
            for (int i = 0; i < jarr.length(); i++) {
                innerJob = jarr.getJSONObject(i);

                DB.insertIntoPriceBook(innerJob.getString(COLUMN_PRICEBOOK_ID),
                        innerJob.getString(COLUMN_PRICEBOOK_NAME),
                        innerJob.getString(COLUMN_CUSTOMER_GROUP),
                        innerJob.getString(COLUMN_OUTLET),
                        innerJob.getString(COLUMN_VALID_FROM),
                        innerJob.getString(COLUMN_VALID_TO),
                        innerJob.getString(COLUMN_CREATED_AT));

            }

            priceBookList = DB.getAllPriceBookList("");

            priceBookAdapter = new PriceBookAdapter(priceBookList, getActivity());
            recyclerViewProductList.setAdapter(priceBookAdapter);
            hideDelayIndicator();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calender.set(Calendar.YEAR, year);
            calender.set(Calendar.MONTH, monthOfYear);
            calender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    private void updateLabel() {
        String myFormat = "dd MMMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        activeEditText.setText(sdf.format(calender.getTime()));
    }

}

