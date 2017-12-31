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

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.DatabaseHelper;
import com.example.pb221.vendaq.main.FragmentDataObserver;
import com.example.pb221.vendaq.main.MyApplication;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.SupplierAdapter;
import com.example.pb221.vendaq.product.productmodel.SupplierPOJO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.pb221.vendaq.main.utils.Utils.TABLE_SUPPLIER_DETAILS;
import static com.example.pb221.vendaq.main.utils.Utils.getSuppliers;

/**
 * Created by pb221 on 29-10-2017.
 */

public class SupplierFragment extends Fragment implements FragmentDataObserver {
    public String result = "";
    DatabaseHelper DB;
    public SupplierAdapter supplierListAdapter;
    private List<SupplierPOJO> supplierList;
    private RecyclerView recyclerViewProductList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_supplier, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        DB = MyApplication.getInstance(getActivity());
        getActivity().setTitle("Suppliers");


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);


        supplierList = new ArrayList<>();
        sendJsonToWebService("1");

/* product adapter list*/

     /*   SupplierPOJO listPOJO = new SupplierPOJO("Jimmys Roasting Beans", "Lorem Ipsum", "0", "12");
        SupplierPOJO listPOJO1 = new SupplierPOJO("Jimmys Roasting Beans", "Lorem Ipsum", "0", "12");
        SupplierPOJO listPOJO2 = new SupplierPOJO("Jimmys Roasting Beans", "Lorem Ipsum", "0", "12");

        supplierList.add(listPOJO);
        supplierList.add(listPOJO1);
        supplierList.add(listPOJO2);*/


   /* supplierListAdapter =new

    SupplierAdapter(supplierList, getActivity());
        recyclerViewProductList.setAdapter(supplierListAdapter);*/

        /* product adapter list*/

        return v;
    }

    private void sendJsonToWebService(String storeId) {

        final JSONObject job = new JSONObject();

        try {
            job.put(getResources().getString(R.string.str_key_storeid), storeId);



            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(getSuppliers, job.toString());
                Log.e("**result IN SU*", result + "");

            }
            getDataFromActivity(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getDataFromActivity(String data) {
        Log.e("**result IN SUPPLIER**", data + "");
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

            supplierList = DB.getAllTableDetails( "");


            supplierListAdapter = new

                    SupplierAdapter(supplierList, getActivity());
            recyclerViewProductList.setAdapter(supplierListAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
/*

{
        "IsError": "0",
        "ErrorCode": "200",
        "ErrorMessage": "",
        "Result": [
        {
        "SupplierId": "1",
        "SupplierName": "Swaroop",
        "SupplierEmail": "thondaswaroop@gmail.com",
        "SupplierPhone": "9876543210",
        "Supplieraddress": "Testing address",
        "DefaultMarkup": "",
        "Description": "test description",
        "NumberOfProducts": 2
        },
        {
        "SupplierId": "2",
        "SupplierName": "Gokulesh",
        "SupplierEmail": "gokulesh@gmail.com",
        "SupplierPhone": "7890654321",
        "Supplieraddress": "Testing address kakianda",
        "DefaultMarkup": "",
        "Description": "test descriptionsfsdfds",
        "NumberOfProducts": 0
        }
        ]
        }*/
