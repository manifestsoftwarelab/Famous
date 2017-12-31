package com.example.pb221.vendaq.product.productview;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.BaseActivity;
import com.example.pb221.vendaq.main.BaseFragment;
import com.example.pb221.vendaq.main.DatabaseHelper;
import com.example.pb221.vendaq.main.FragmentDataObserver;
import com.example.pb221.vendaq.main.MyApplication;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.ProductTagsAdapter;
import com.example.pb221.vendaq.product.productmodel.ProductTagsPOJO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.pb221.vendaq.main.utils.Utils.TABLE_TAGS;
import static com.example.pb221.vendaq.main.utils.Utils.getTags;

/**
 * Created by pb221 on 29-10-2017.
 */

public class ProductTagsFragment extends BaseFragment {

    public String result = "";
    DatabaseHelper DB;
    public ProductTagsAdapter productTagAdapter;
    private List<ProductTagsPOJO> productTagList;
    private RecyclerView recyclerViewProductList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_tags, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        DB = MyApplication.getInstance(getActivity());
        getActivity().setTitle("Product Tags");

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);


        productTagList = new ArrayList<>();

        sendJsonToWebService("1");

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

        /* product adapter list*/

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;

        final Dialog dialog = new Dialog(getActivity());
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog_add_tag);
        // Set dialog title
        dialog.setTitle("Add Tag");

        dialog.getWindow().setLayout((5 * width) / 7, (2 * height) / 5);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);

        final EditText tagName = (EditText) dialog.findViewById(R.id.tagNameEditText);
        Button addTagsButton = (Button) v.findViewById(R.id.add_Tag_Button);

        Button btnCancel_Tag = (Button) dialog.findViewById(R.id.cancel_Tag);
        Button btnAdd_Tag = (Button) dialog.findViewById(R.id.addTagButton);

        btnCancel_Tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagName.setText("", EditText.BufferType.EDITABLE);
                dialog.dismiss();
            }
        });

        btnAdd_Tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        addTagsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        return v;
    }

    private void sendJsonToWebService(String productId) {

        showDelayIndicator();
        final JSONObject job = new JSONObject();

        try {
          //  job.put(getResources().getString(R.string.str_key_productid), productId);


            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(getTags, job.toString());
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

            DB.deleteFromTable(TABLE_TAGS);
            for (int i = 0; i < jarr.length(); i++) {
                innerJob = jarr.getJSONObject(i);

                DB.insertIntoTags(
                        innerJob.getString("ProductTagId"),
                        innerJob.getString("ProductTagName"),
                        innerJob.getString("NumberOfProducts")
                );

            }

            productTagList = DB.getAllTags("");

            productTagAdapter = new ProductTagsAdapter(productTagList, getActivity());
            recyclerViewProductList.setAdapter(productTagAdapter);
            hideDelayIndicator();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}