package com.example.pb221.vendaq.product.productview;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.DatabaseHelper;
import com.example.pb221.vendaq.main.MyApplication;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.ProductTypeAdapter;
import com.example.pb221.vendaq.product.productmodel.ProductTypePOJO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.pb221.vendaq.main.utils.Utils.getTypes;

/**
 * Created by pb221 on 29-10-2017.
 */

public class ProductTypeFragment extends Fragment {

    public ProductTypeAdapter productTypeListAdapter;
    private List<ProductTypePOJO> productTypeList;
    private RecyclerView recyclerViewProductList;
    public String result = "";
    DatabaseHelper DB;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_type, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        getActivity().setTitle("Product Types");
        DB = MyApplication.getInstance(getActivity());


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);


        productTypeList = new ArrayList<>();
        sendJsonToWebService();

/* product adapter list*/

//        ProductTypePOJO listPOJO = new ProductTypePOJO("Jimmys Roasting Beans", "12");
//        ProductTypePOJO listPOJO1 = new ProductTypePOJO("Jimmys Roza", "12");
//        ProductTypePOJO listPOJO2 = new ProductTypePOJO("Jimmys jims", "12");
//
//        productTypeList.add(listPOJO);
//        productTypeList.add(listPOJO1);
//        productTypeList.add(listPOJO2);
//
//
//        productTypeListAdapter = new ProductTypeAdapter(productTypeList, getActivity());
//        recyclerViewProductList.setAdapter(productTypeListAdapter);
//
//        /* product adapter list*/


        return v;
    }

    private void sendJsonToWebService() {

        final JSONObject job = new JSONObject();

        try {

            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(getTypes, job.toString());
                Log.e("**result IN SU*", result + "");

            }
            getDataFromActivity(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDataFromActivity(String data) {
        Log.e("**result IN Tags**", data + "");
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

                DB.insertIntoProductType(
                        innerJob.getString("ProducttypeId"),
                        innerJob.getString("TypeName"),
                        innerJob.getString("NumberOfProducts")
                );

            }

            productTypeList = DB.getAllProductType();

            productTypeListAdapter = new ProductTypeAdapter(productTypeList, getActivity());
            recyclerViewProductList.setAdapter(productTypeListAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

