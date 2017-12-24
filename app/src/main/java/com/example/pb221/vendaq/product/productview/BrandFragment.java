package com.example.pb221.vendaq.product.productview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

}
//4
//approach document complete
