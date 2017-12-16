package com.example.pb221.vendaq.sell.sellview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.selladapter.SalesHistoryAdapter;
import com.example.pb221.vendaq.sell.sellmodel.SalesHistoryPOJO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb221 on 31-10-2017.
 */

public class SaleHistoryFragment extends Fragment {
    private TextView tvDetails, tvPricing, tvProductTypeInventory;
    private View viewDetails, viewProductTypeInventory, viewPricing;
    public SalesHistoryAdapter salesHistoryAdapter;
    private List<SalesHistoryPOJO> saleList;

    private RelativeLayout layoutProcessReturns, layoutContinousSale, layoutAllSells;
    private RecyclerView recyclerViewProductListProcessReturns;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sale_history, null);

        getActivity().setTitle("Sales History");

        recyclerViewProductListProcessReturns = (RecyclerView) v.findViewById(R.id.recyclerViewProductListProcessReturns);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductListProcessReturns.setLayoutManager(llm);

        saleList = new ArrayList<>();
        layoutProcessReturns = (RelativeLayout) v.findViewById(R.id.layoutProcessReturns);
        layoutContinousSale = (RelativeLayout) v.findViewById(R.id.layoutContinousSale);
        layoutAllSells = (RelativeLayout) v.findViewById(R.id.layoutAllSells);

        tvDetails = (TextView) v.findViewById(R.id.tvDetails);
        tvPricing = (TextView) v.findViewById(R.id.tvPricing);
        tvProductTypeInventory = (TextView) v.findViewById(R.id.tvProductTypeInventory);

        viewDetails = v.findViewById(R.id.viewDetails);
        viewProductTypeInventory = v.findViewById(R.id.viewProductTypeInventory);
        viewPricing = v.findViewById(R.id.viewPricing);


        viewDetails.setVisibility(View.VISIBLE);
        tvDetails.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));
        viewDetails.setBackgroundColor(Color.parseColor("#F39C0F"));


        layoutProcessReturns.setVisibility(View.VISIBLE);
        layoutContinousSale.setVisibility(View.GONE);
        layoutAllSells.setVisibility(View.GONE);
        tvDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewDetails.setVisibility(View.VISIBLE);
                tvDetails.setTextColor(getResources().getColor(R.color.buttonSelectedBackground));

                tvPricing.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                tvProductTypeInventory.setTextColor(getResources().getColor(R.color.buttonNotSelectedBackground));
                viewDetails.setBackgroundColor(Color.parseColor("#F39C0F"));
                layoutProcessReturns.setVisibility(View.VISIBLE);
                layoutContinousSale.setVisibility(View.GONE);
                layoutAllSells.setVisibility(View.GONE);

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
                layoutContinousSale.setVisibility(View.GONE);
                layoutProcessReturns.setVisibility(View.VISIBLE);
                layoutAllSells.setVisibility(View.GONE);
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

                layoutContinousSale.setVisibility(View.GONE);
                layoutProcessReturns.setVisibility(View.GONE);
                layoutAllSells.setVisibility(View.VISIBLE);

            }
        });


        Spinner spinner1 = (Spinner) v.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) v.findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) v.findViewById(R.id.spinner4);
        Spinner spinner5 = (Spinner) v.findViewById(R.id.spinner5);
        Spinner spinner6 = (Spinner) v.findViewById(R.id.spinner6);
        Spinner spinner7 = (Spinner) v.findViewById(R.id.spinner7);
        Spinner spinner8 = (Spinner) v.findViewById(R.id.spinner8);
        Spinner spinner9 = (Spinner) v.findViewById(R.id.spinner9);
        Spinner spinner10 = (Spinner) v.findViewById(R.id.spinner10);
        Spinner spinner11 = (Spinner) v.findViewById(R.id.spinner11);
        Spinner spinner12 = (Spinner) v.findViewById(R.id.spinner12);


        String[] values = getActivity().getResources().getStringArray(R.array.spinner_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
        spinner7.setAdapter(adapter);
        spinner8.setAdapter(adapter);
        spinner9.setAdapter(adapter);
        spinner10.setAdapter(adapter);
        spinner11.setAdapter(adapter);
        spinner12.setAdapter(adapter);


        SalesHistoryPOJO listPOJO = new SalesHistoryPOJO("12 Oct 2017 8:05pm", "22", "Manager \n main outlet", "-", "-", "Rp3.00", "completed");
        SalesHistoryPOJO listPOJO1 = new SalesHistoryPOJO("12 Oct 2017 8:05pm", "22", "Manager \n main outlet", "-", "-", "Rp3.00", "completed");
        SalesHistoryPOJO listPOJO2 = new SalesHistoryPOJO("12 Oct 2017 8:05pm", "22", "Manager \n main outlet", "-", "-", "Rp3.00", "completed");

        saleList.add(listPOJO);
        saleList.add(listPOJO1);
        saleList.add(listPOJO2);


        salesHistoryAdapter = new SalesHistoryAdapter(saleList, getActivity());
        recyclerViewProductListProcessReturns.setAdapter(salesHistoryAdapter);

        return v;

    }
}