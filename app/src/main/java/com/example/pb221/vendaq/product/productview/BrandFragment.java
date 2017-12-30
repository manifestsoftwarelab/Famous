package com.example.pb221.vendaq.product.productview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pb221.vendaq.main.DatabaseHelper;
import com.example.pb221.vendaq.main.MyApplication;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.BrandAdapter;
import com.example.pb221.vendaq.product.productmodel.BrandPOJO;
import com.example.pb221.vendaq.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.pb221.vendaq.main.utils.Utils.addBrand;
import static com.example.pb221.vendaq.main.utils.Utils.getBrands;

/**
 * Created by pb221 on 29-10-2017.
 */

public class BrandFragment extends Fragment {

    public String result = "";
    DatabaseHelper DB;
    public BrandAdapter brandListAdapter;
    private List<BrandPOJO> brandList;
    private RecyclerView recyclerViewProductList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_brands, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        Button btnAddBrand = (Button) v.findViewById(R.id.addBrandButton);

        getActivity().setTitle("Brands");
        DB = MyApplication.getInstance(getActivity());


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);

        brandList = new ArrayList<>();

        sendJsonToWebService("4");


         /* Brand adapter list*/
/*
        BrandPOJO brandPojo1 = new BrandPOJO("Jimmys Roasting Beans", "Lorem Ipsum", "12");
        BrandPOJO brandPojo2 = new BrandPOJO("Jimmys Roasting Beans", "Lorem Ipsum", "12");
        BrandPOJO brandPojo3 = new BrandPOJO("Jimmys Roasting Beans", "Lorem Ipsum", "12");

        brandList.add(brandPojo1);
        brandList.add(brandPojo2);
        brandList.add(brandPojo3);

        brandListAdapter = new BrandAdapter(brandList, getActivity());
        recyclerViewProductList.setAdapter(brandListAdapter);

          /* Brand adapter list*/

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;

        final Dialog dialog = new Dialog(getActivity());
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog_add_brand);
        // Set dialog title
        dialog.setTitle("Add Brand");

        dialog.getWindow().setLayout((5 * width) / 7, (3 * height) / 5);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);

        final EditText brandName = (EditText) dialog.findViewById(R.id.brandName);
        final EditText description = (EditText) dialog.findViewById(R.id.descriptionEditText);

        Button btnCancel_Brand = (Button) dialog.findViewById(R.id.cancel_brand);
        Button btnAdd_Brand = (Button) dialog.findViewById(R.id.add_brandButton);

        btnCancel_Brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brandName.setText("", EditText.BufferType.EDITABLE);
                description.setText("",EditText.BufferType.EDITABLE);
                dialog.dismiss();
            }
        });

        btnAdd_Brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendJsonToWebService(brandName.getText().toString(),description.getText().toString());
                dialog.dismiss();
                sendJsonToWebService("4");
            }
        });

        btnAddBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        return v;
    }

    private void sendJsonToWebService(String catId) {

        final JSONObject job = new JSONObject();

        try {
            job.put(getResources().getString(R.string.str_key_categoryid), catId);


            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(getBrands, job.toString());
                Log.e("**result IN SU*", result + "");

            }
            getDataFromActivity(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getDataFromActivity(String data) {
        Log.e("**result IN brand**", data + "");
        try {
            JSONObject job = new JSONObject(data);

            String isError = job.getString("IsError");
            if (isError.equalsIgnoreCase("0")) {
                updateUI(job);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updateUI(JSONObject job) {

        try {
            JSONArray jarr = job.getJSONArray("Result");
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

            brandList = DB.getAllBrandsTableDetails("");


            brandListAdapter = new
                    BrandAdapter(brandList, getActivity());
            recyclerViewProductList.setAdapter(brandListAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    private void sendJsonToWebService(String brandName, String brandDescription) {

        final JSONObject job = new JSONObject();

        try {
            job.put("title", brandName);
            job.put("description",brandDescription);
            job.put("category", "4");

            Log.e("**json obj***", job.toString());
/*

            "category : 1
title : Dell
description : test description"*/


            if (android.os.Build.VERSION.SDK_INT > 9) {
                result = WebCallFragment.execute(addBrand, job.toString());
                Log.e("**result IN SU*", result + "");
            }

            getDataFromActivity(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
//4
//approach document complete
