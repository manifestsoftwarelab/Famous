package com.example.pb221.vendaq.product.productview;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pb221.vendaq.main.DatabaseHelper;
import com.example.pb221.vendaq.main.MyApplication;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.ProductListAdapter;
import com.example.pb221.vendaq.product.productmodel.BrandPOJO;
import com.example.pb221.vendaq.product.productmodel.OutletsPOJONew;
import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.product.productmodel.ProductPOJONew;
import com.example.pb221.vendaq.product.productmodel.ProductTagsPOJO;
import com.example.pb221.vendaq.product.productmodel.ProductTypePOJO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.pb221.vendaq.main.utils.Utils.getProducts;

/**
 * Created by pb221 on 29-10-2017.
 */

public class ProductListFragment extends Fragment {

    public ProductListAdapter productListAdapter;

    private List<ProductTagsPOJO> productTagList;
    private String[] productTags ;

    private List<BrandPOJO> brandList;
    private String[] productbrand;

    private List<ProductTypePOJO> productTypeList;
    private String[] productType;


    private List<ProductPOJONew> productList;
    private List<OutletsPOJONew> outletList;
    private RecyclerView recyclerViewProductList;
    DatabaseHelper DB;

    private Button btn_addProduct;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String result;

    private LinearLayout layoutActiveSales, layoutInactiveSales, layoutAllSales;
    private TextView textvwActive, textvwInActive, textvwAll;
    private View viewActive, viewInActive, viewAll;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_products, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        btn_addProduct = (Button) v.findViewById(R.id.btn_addProduct);

        DB = MyApplication.getInstance(getActivity());

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);

        productList = new ArrayList<>();
        productTagList = new ArrayList<>();
        brandList = new ArrayList<>();
        productTypeList = new ArrayList<>();
        getActivity().setTitle("Products");


        brandList = DB.getAllBrandsTableDetails("");
        if (brandList.size() > 0) {
            productbrand = new String[brandList.size()];
            for (int i = 0; i < brandList.size(); i++) {
                productbrand[i] = brandList.get(i).getBrandName();
            }
        }
        productTagList = DB.getAllTags("");

        if (productTagList.size() > 0) {
            productTags = new String[productTagList.size()];

            for (int i = 0; i < productTagList.size(); i++) {
                productTags[i] = productTagList.get(i).getTagName();
            }
        }
        productTypeList = DB.getAllProductType();

        if (productTypeList.size() > 0) {
            productType = new String[productTypeList.size()];

            for (int i = 0; i < productTypeList.size(); i++) {
                productType[i] = productTypeList.get(i).getProductTypeName();
            }
        }


        layoutActiveSales = (LinearLayout) v.findViewById(R.id.layoutActiveSales);
        layoutInactiveSales = (LinearLayout) v.findViewById(R.id.layoutInactiveSales);
        layoutAllSales = (LinearLayout) v.findViewById(R.id.layoutAllSales);

        textvwActive = (TextView) v.findViewById(R.id.textvwActive);
        textvwInActive = (TextView) v.findViewById(R.id.textvwInActive);
        textvwAll = (TextView) v.findViewById(R.id.textvwAll);


        viewActive = v.findViewById(R.id.viewActive);
        viewInActive = v.findViewById(R.id.viewInActive);
        viewAll = v.findViewById(R.id.viewAll);


        textvwActive.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
        textvwInActive.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
        textvwAll.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
        viewActive.setBackgroundColor(Color.parseColor("#6692B0"));
        viewInActive.setBackgroundColor(Color.parseColor("#6692B0"));
        viewAll.setBackgroundColor(Color.parseColor("#6692B0"));

        layoutActiveSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textvwActive.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));
                textvwInActive.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                textvwAll.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                viewActive.setBackgroundColor(Color.parseColor("#F39C0F"));
                viewInActive.setBackgroundColor(Color.parseColor("#6692B0"));
                viewAll.setBackgroundColor(Color.parseColor("#6692B0"));
            }
        });

        layoutInactiveSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textvwActive.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                textvwInActive.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));
                textvwAll.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                viewActive.setBackgroundColor(Color.parseColor("#6692B0"));
                viewInActive.setBackgroundColor(Color.parseColor("#F39C0F"));
                viewAll.setBackgroundColor(Color.parseColor("#6692B0"));
            }
        });

        layoutAllSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textvwActive.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                textvwInActive.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                textvwAll.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));
                viewActive.setBackgroundColor(Color.parseColor("#6692B0"));
                viewInActive.setBackgroundColor(Color.parseColor("#6692B0"));
                viewAll.setBackgroundColor(Color.parseColor("#F39C0F"));
            }
        });



/* product adapter list*/

        /*ProductListPOJO listPOJO = new ProductListPOJO("Freshly Squeezed Juice", "27 Sep 2017", "Juice Orange", "-", "Summer S", "-", 50.7, 5);
        ProductListPOJO listPOJO1 = new ProductListPOJO("Freshly Squeezed Juice", "27 Sep 2017", "Juice Orange", "-", "Summer S", "-", 50.7, 5);
        ProductListPOJO listPOJO2 = new ProductListPOJO("Freshly Squeezed Juice", "27 Sep 2017", "Juice Orange", "-", "Summer S", "-", 50.7, 5);

        productList.add(listPOJO);
        productList.add(listPOJO1);
        productList.add(listPOJO2);


        productListAdapter = new ProductListAdapter(productList, getActivity());
        recyclerViewProductList.setAdapter(productListAdapter);*/

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        Spinner spProductType = (Spinner) v.findViewById(R.id.spProductType);
        Spinner spProductSupplier = (Spinner) v.findViewById(R.id.spProductSupplier);
        Spinner spProductBrand = (Spinner) v.findViewById(R.id.spProductBrand);


        String[] values = {"b", "b", "b", "b"};
//        getActivity().getResources().getStringArray(R.array.spinner_array);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, productType);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, productType);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, productbrand);
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spProductType.setAdapter(adapter1);
        spProductSupplier.setAdapter(adapter2);
        spProductBrand.setAdapter(adapter3);


        spProductType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spProductSupplier.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spProductBrand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        /* product adapter list*/
        btn_addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddProductFragment fragmentPriceFragment = new AddProductFragment();
                fragmentTransaction.replace(R.id.frameLayoutcontainer, fragmentPriceFragment, "Price Book ");
                fragmentTransaction.commit();
            }
        });

        return v;
    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private void sendJsonToWebService(String storeId) {

        final JSONObject job = new JSONObject();

        try {
            job.put(getResources().getString(R.string.str_key_storeid), "1");


            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(getProducts, job.toString());
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
            JSONObject outletJob = null;

            for (int i = 0; i < jarr.length(); i++) {
                innerJob = jarr.getJSONObject(i);

                ProductPOJONew productPOJONew = new ProductPOJONew();

                productPOJONew.setPid(innerJob.getString("Pid"));
                productPOJONew.setName(innerJob.getString("Name"));
                productPOJONew.setBrandid(innerJob.getString("brandid"));
                productPOJONew.setBrand(innerJob.getString("brand"));
                productPOJONew.setHandle(innerJob.getString("handle"));
                productPOJONew.setDescription(innerJob.getString("description"));
                productPOJONew.setTags(innerJob.getString("tags"));
                productPOJONew.setIsSellable(innerJob.getString("isSellable"));
                productPOJONew.setSKU(innerJob.getString("SKU"));
                productPOJONew.setSupplierCode(innerJob.getString("supplierCode"));
                productPOJONew.setSupplier(innerJob.getString("supplier"));
                productPOJONew.setSupplyprice(innerJob.getString("Supplyprice"));
                productPOJONew.setUserid(innerJob.getString("userid"));
                productPOJONew.setIsInventory(innerJob.getString("IsInventory"));
                productPOJONew.setMarkup(innerJob.getString("Markup"));
                productPOJONew.setCount(innerJob.getString("Count"));
                productPOJONew.setCreatedDate(innerJob.getString("CreatedDate"));

                JSONArray jarrOutlets = innerJob.getJSONArray("Outlets");

                for (int j = 0; j < jarr.length(); j++) {

                    OutletsPOJONew outletsPOJONew = new OutletsPOJONew();
                    outletJob = jarrOutlets.getJSONObject(j);

                    outletsPOJONew.setOutletName(outletJob.getString("OutletName"));
                    outletsPOJONew.setCurrentInventory(outletJob.getString("CurrentInventory"));
                    outletsPOJONew.setReOrderPoint(outletJob.getString("ReOrderPoint"));
                    outletsPOJONew.setReOrderQuantity(outletJob.getString("ReOrderQuantity"));

                    outletList.add(outletsPOJONew);
                }


                JSONArray jarrTax = innerJob.getJSONArray("Tax");

                for (int j = 0; j < jarrTax.length(); j++) {

                    outletJob = jarrTax.getJSONObject(j);
                    outletJob.getString("Outlet");
                    outletJob.getString("Tax");
                }

                JSONArray jarrVarients = innerJob.getJSONArray("Varients");

                for (int j = 0; j < jarrVarients.length(); j++) {

                    outletJob = jarrVarients.getJSONObject(j);
                    outletJob.getString("VariantName");
                    outletJob.getString("VariantCount");
                    outletJob.getString("SupplierCode");
                    outletJob.getString("SupplierPrice");
                    outletJob.getString("RetailPrice");
                }


            }

            productList = DB.getAllTableDetails("");


            productListAdapter = new ProductListAdapter(productList, getActivity());
            recyclerViewProductList.setAdapter(productListAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}

