package com.example.pb221.vendaq.product.productview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.BaseFragment;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.PriceBookAdapter;
import com.example.pb221.vendaq.product.productmodel.PriceBooksPOJO;

import org.json.JSONObject;

import java.util.List;

import static com.example.pb221.vendaq.main.utils.Utils.addProducts;

/**
 * Created by pb221 on 04-11-2017.
 */

public class AddProductFragment extends BaseFragment {
    String result;
    public PriceBookAdapter priceBookAdapter;
    public Button btnCancelProduct, btnAddProduct;
    private TextView tvDetails, tvPricing, tvProductTypeInventory;
    private View viewDetails, viewProductTypeInventory, viewPricing;
    private List<PriceBooksPOJO> priceBookList;
    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6;
    private RecyclerView recyclerViewOutlets;
    private EditText edtProductName, edtDescription, edtTags; //details
    private Spinner spProductType, spProductBrand, spSupplier; //details
    private EditText edtSupplierCode, edtSupplierPrice, edtMarkupPercentage, edtRetailPrice, edtSalesAccountCode, edtPurchaseAccountCode; //pricing
    private EditText edtSKU;//PRODUCT TYPE N INVENTORY
    private Switch switchIsVarient;//PRODUCT TYPE N INVENTORY


    private RelativeLayout layoutDetails, layoutPricing, layoutProductTypeInvenory;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_product_fragment, null);
        getActivity().setTitle("Add Product");
        initView(v);


        viewDetails.setVisibility(View.VISIBLE);
        tvDetails.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));
        viewDetails.setBackgroundColor(Color.parseColor("#F39C0F"));


        viewPricing.setBackgroundColor(Color.parseColor("#6692B0"));
        tvPricing.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
        tvProductTypeInventory.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
        viewProductTypeInventory.setBackgroundColor(Color.parseColor("#6692B0"));


        layoutDetails.setVisibility(View.VISIBLE);
        layoutProductTypeInvenory.setVisibility(View.GONE);
        layoutPricing.setVisibility(View.GONE);
        tvDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewDetails.setVisibility(View.VISIBLE);
                tvDetails.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));

                tvPricing.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                tvProductTypeInventory.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                viewDetails.setBackgroundColor(Color.parseColor("#F39C0F"));
                layoutDetails.setVisibility(View.VISIBLE);
                layoutPricing.setVisibility(View.GONE);
                layoutProductTypeInvenory.setVisibility(View.GONE);

                viewPricing.setVisibility(View.INVISIBLE);
                viewProductTypeInventory.setVisibility(View.INVISIBLE);


            }
        });


        tvPricing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPricing.setVisibility(View.VISIBLE);
                tvPricing.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));
                tvDetails.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                tvProductTypeInventory.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                viewPricing.setBackgroundColor(Color.parseColor("#F39C0F"));

                viewDetails.setVisibility(View.INVISIBLE);
                viewProductTypeInventory.setVisibility(View.INVISIBLE);
                layoutDetails.setVisibility(View.GONE);
                layoutPricing.setVisibility(View.VISIBLE);
                layoutProductTypeInvenory.setVisibility(View.GONE);
            }
        });
        tvProductTypeInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewProductTypeInventory.setVisibility(View.VISIBLE);
                tvProductTypeInventory.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));

                tvDetails.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                tvPricing.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                viewProductTypeInventory.setBackgroundColor(Color.parseColor("#F39C0F"));

                viewPricing.setVisibility(View.INVISIBLE);
                viewDetails.setVisibility(View.INVISIBLE);

                layoutDetails.setVisibility(View.GONE);
                layoutPricing.setVisibility(View.GONE);
                layoutProductTypeInvenory.setVisibility(View.VISIBLE);

            }
        });
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDelayIndicator();
                sendJsonToWebService();

            }
        });
        return v;
    }

    private void initView(View v) {

        tvDetails = (TextView) v.findViewById(R.id.tvDetails);
        tvPricing = (TextView) v.findViewById(R.id.tvPricing);
        tvProductTypeInventory = (TextView) v.findViewById(R.id.tvProductTypeInventory);

        viewDetails = v.findViewById(R.id.viewDetails);
        viewProductTypeInventory = v.findViewById(R.id.viewProductTypeInventory);
        viewPricing = v.findViewById(R.id.viewPricing);

        layoutDetails = (RelativeLayout) v.findViewById(R.id.layoutDetails);
        layoutPricing = (RelativeLayout) v.findViewById(R.id.layoutPricing);
        layoutProductTypeInvenory = (RelativeLayout) v.findViewById(R.id.layoutProductTypeInvenory);

        edtProductName = (EditText) v.findViewById(R.id.edtProductName);
        edtDescription = (EditText) v.findViewById(R.id.edtDescription);
        edtTags = (EditText) v.findViewById(R.id.edtTags);
        recyclerViewOutlets = (RecyclerView) v.findViewById(R.id.recyclerViewOutlets);
        spProductType = (Spinner) v.findViewById(R.id.spProductType);
        spProductBrand = (Spinner) v.findViewById(R.id.spProductBrand);
        spSupplier = (Spinner) v.findViewById(R.id.spSupplier);
        edtSupplierCode = (EditText) v.findViewById(R.id.edtSupplierCode);
        edtSupplierPrice = (EditText) v.findViewById(R.id.edtSupplierPrice);
        edtMarkupPercentage = (EditText) v.findViewById(R.id.edtMarkupPercentage);
        edtRetailPrice = (EditText) v.findViewById(R.id.edtRetailPrice);
        edtSalesAccountCode = (EditText) v.findViewById(R.id.edtSalesAccountCode);
        edtPurchaseAccountCode = (EditText) v.findViewById(R.id.edtPurchaseAccountCode);
        edtSKU = (EditText) v.findViewById(R.id.edtSKU);
        switchIsVarient = (Switch) v.findViewById(R.id.switchIsVarient);

        btnCancelProduct = (Button) v.findViewById(R.id.btnCancelProduct);
        btnAddProduct = (Button) v.findViewById(R.id.btnAddProduct);
    }


    private void sendJsonToWebService() {

        final JSONObject job = new JSONObject();


        try {
            job.put("name", edtProductName.getText().toString());
            job.put("description", edtDescription.getText().toString());
            job.put("tags", edtTags.getText().toString());
            job.put("userid", "3");
            job.put("brand", "2");
            job.put("handle", "1");
            job.put("store_id", "1");
            job.put("isellable", true);
            job.put("type", 1);
            job.put("isinventory", true);
            job.put("category", "4");
            job.put("supplier", "1");
            job.put("code", "p1");
            job.put("markup", edtMarkupPercentage.getText().toString());
            job.put("supplierprice", edtSupplierPrice.getText().toString());
            job.put("sku", edtSKU.getText().toString());
            job.put("stock", "10");


            if (android.os.Build.VERSION.SDK_INT > 9) {
                Log.e("**job.toString()***", "" + job.toString());

                result = WebCallFragment.execute(addProducts, job.toString());
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
            hideDelayIndicator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updateUI(JSONObject job) {

        Toast.makeText(getActivity(), "Product Added successfully", Toast.LENGTH_SHORT).show();
        Log.e("***add product", job + "");

    }
}