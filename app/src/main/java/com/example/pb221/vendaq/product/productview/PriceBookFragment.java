package com.example.pb221.vendaq.product.productview;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import static com.example.pb221.vendaq.main.utils.Utils.addPriceBook;

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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.PriceBookAdapter;
import com.example.pb221.vendaq.product.productmodel.PriceBooksPOJO;
import com.example.pb221.vendaq.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb221 on 29-10-2017.
 */

public class PriceBookFragment extends Fragment {

    public PriceBookAdapter priceBookAdapter;
    public String result = "";

    String customerGroup;
    String customerOutlet;

    private List<PriceBooksPOJO> priceBookList;
    private Button btnAddPriceBook;
    private RecyclerView recyclerViewProductList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_price_books, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        btnAddPriceBook = (Button) v.findViewById(R.id.btnAddPriceBook);
        getActivity().setTitle("Price Books");

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;


        priceBookList = new ArrayList<>();

/* product adapter list*/

        PriceBooksPOJO priceBookPOJO1 = new PriceBooksPOJO("General Price Book(All Products)", "All Customers", "All Outlet", "12/08/2017", "12/09/2017", "27 Sep 2017 1:47 pm");
        PriceBooksPOJO priceBookPOJO2 = new PriceBooksPOJO("General Price Book(All Products)", "All Customers", "All Outlet", "12/08/2017", "12/09/2017", "27 Sep 2017 1:47 pm");
        PriceBooksPOJO priceBookPOJO3 = new PriceBooksPOJO("General Price Book(All Products)", "All Customers", "All Outlet", "12/08/2017", "12/09/2017", "27 Sep 2017 1:47 pm");

        priceBookList.add(priceBookPOJO1);
        priceBookList.add(priceBookPOJO2);
        priceBookList.add(priceBookPOJO3);

        priceBookAdapter = new PriceBookAdapter(priceBookList, getActivity());
        recyclerViewProductList.setAdapter(priceBookAdapter);


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
                final EditText edtValidFrom = (EditText) dialog.findViewById(R.id.edtValidFrom);
                final EditText edtValidTo = (EditText) dialog.findViewById(R.id.edtValidTo);

                final Spinner spCustomerGroup = (Spinner) dialog.findViewById(R.id.spCustomerGroup);
                final Spinner spCustomerOutlet = (Spinner) dialog.findViewById(R.id.spCustomerOutlet);

                Button btnCancelPricebook = (Button) dialog.findViewById(R.id.btnCancelPricebook);
                Button btnAddPricebook = (Button) dialog.findViewById(R.id.btnAddPricebook);

                btnAddPricebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendJsonToWebService(edtPriceBook.getText().toString(), edtValidFrom.getText().toString(), edtValidTo.getText().toString(), customerGroup, customerOutlet);
                        dialog.dismiss();
                    }
                });
                btnCancelPricebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                String[] values = getActivity().getResources().getStringArray(R.array.spinner_array);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spCustomerGroup.setAdapter(adapter);
                spCustomerOutlet.setAdapter(adapter);


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

    private void sendJsonToWebService(String priceBookName, String priceBookValidFrom, String priceBookValidTo, String customerGroup, String customerOutlet) {

        final JSONObject job = new JSONObject();

        try {
            job.put("pricebookname", priceBookName);
            job.put("customer_group", "sdads");
            job.put("outlet", "daad");
            job.put("ValidFrom", priceBookValidFrom);
            job.put("ValidTo", priceBookValidTo);
            job.put("IsInstore", "true");
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
}

