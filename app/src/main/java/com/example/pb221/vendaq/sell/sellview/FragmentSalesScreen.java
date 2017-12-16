package com.example.pb221.vendaq.sell.sellview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;


import java.util.ArrayList;
import java.util.List;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.selladapter.PayListAdapter;
import com.example.pb221.vendaq.sell.sellmodel.PayModel;
import com.example.pb221.vendaq.sell.selladapter.ProductList1Adapter;
import com.example.pb221.vendaq.sell.selladapter.ProductListAdapter;
import com.example.pb221.vendaq.sell.selladapter.ProductMenuAdapter;
import com.example.pb221.vendaq.sell.sellmodel.ProductMenuModel;
import com.example.pb221.vendaq.sell.sellmodel.Productmodel;

/**
 * Created by pb221 on 04-11-2017.
 */

public class FragmentSalesScreen extends Fragment {

    private RecyclerView mProductList;
    private RecyclerView mPayList;
    private RecyclerView mProductsmenu;
    private ExpandableListView mProductListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sell_screen, null);
        mProductList = (RecyclerView) v.findViewById(R.id.product_recyclerview);
        mPayList = (RecyclerView) v.findViewById(R.id.paylist_recyclerview);
        mProductsmenu = (RecyclerView) v.findViewById(R.id.productmenu);
        mProductListView = (ExpandableListView) v.findViewById(R.id.product_listview);


        getActivity().setTitle("Main Layout");




        mProductList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mPayList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mProductsmenu.setLayoutManager(new GridLayoutManager(getActivity(),4));

        List<Productmodel> productmodelList = new ArrayList<>();

        Productmodel productmodel1 = new Productmodel();
        productmodel1.setProduct_id(1);
        productmodel1.setProduct_name("Tea For Two Set");
        productmodel1.setProduct_type("White");
        productmodel1.setProduct_price(109.00f);
        productmodelList.add(productmodel1);


        Productmodel productmodel2 = new Productmodel();
        productmodel2.setProduct_id(1);
        productmodel2.setProduct_name("Tea For Two Set");
        productmodel2.setProduct_type("Slate");
        productmodel2.setProduct_price(109.00f);
        productmodelList.add(productmodel2);

        Productmodel productmodel3 = new Productmodel();
        productmodel3.setProduct_id(1);
        productmodel3.setProduct_name("Splatter Vase");
        productmodel3.setProduct_type("White");
        productmodel3.setProduct_price(59.00f);
        productmodelList.add(productmodel3);

        Productmodel productmodel4 = new Productmodel();
        productmodel4.setProduct_id(1);
        productmodel4.setProduct_name("Marley Round Rope Basket");
        productmodel4.setProduct_type("Chalk/Large");
        productmodel4.setProduct_price(35.00f);
        productmodelList.add(productmodel4);

        ProductList1Adapter productList1Adapter = new ProductList1Adapter(getActivity(),productmodelList);
        mProductListView.setAdapter(productList1Adapter);


        ProductListAdapter productListAdapter = new ProductListAdapter(getActivity(),productmodelList);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        mProductList.addItemDecoration(dividerItemDecoration);
        mProductList.setAdapter(productListAdapter);


        List<PayModel> payList = new ArrayList<>();

        for (int i=0;i<2;i++) {
            PayModel payModel = new PayModel();
            payModel.setPayTitle("SUB TOTAL");
            payModel.setPrice(25.00f);
            payList.add(payModel);
        }

        PayListAdapter payListAdapter = new PayListAdapter(getActivity(),payList);
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        mPayList.addItemDecoration(dividerItemDecoration1);
        mPayList.setAdapter(payListAdapter);


        List<ProductMenuModel> productMenuList = new ArrayList<>();
        for (int i=0;i<20;i++) {
            ProductMenuModel productMenuModel = new ProductMenuModel();
            productMenuModel.setProductname("Moon Mug");
            productMenuList.add(productMenuModel);
        }

        ProductMenuAdapter productMenuAdapter = new ProductMenuAdapter(getActivity(),productMenuList);
        mProductsmenu.setAdapter(productMenuAdapter);
return v;
    }
}