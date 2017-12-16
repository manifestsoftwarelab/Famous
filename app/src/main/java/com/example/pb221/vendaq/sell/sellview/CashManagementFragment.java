package com.example.pb221.vendaq.sell.sellview;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.example.pb221.vendaq.sell.selladapter.CashManagementAdapter;
import com.example.pb221.vendaq.sell.sellmodel.CashManagementPOJO;
import com.example.pb221.vendaq.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb221 on 28-10-2017.
 */

public class CashManagementFragment extends Fragment {

    public CashManagementAdapter cashListAdapter;
    private List<CashManagementPOJO> cashList;
    private Button btnRemovecash, btnAddcash;
    private RecyclerView recyclerViewProductList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cash_management, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        getActivity().setTitle("Cash Management");


        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;

        getActivity().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        btnRemovecash = (Button) v.findViewById(R.id.btnRemovecash);
        btnAddcash = (Button) v.findViewById(R.id.btnAddcash);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);


        cashList = new ArrayList<>();

             /* Cash Management adapter list*/

        CashManagementPOJO cashManagementPOJO1 = new CashManagementPOJO("12:01", "manager(manager)", "niranjanniur04@gmail.com", "Opening float", "1234.00");
        CashManagementPOJO cashManagementPOJO2 = new CashManagementPOJO("12:01", "manager(manager)", "niranjanniur04@gmail.com", "Opening float", "1234.00");
        CashManagementPOJO cashManagementPOJO3 = new CashManagementPOJO("12:01", "manager(manager)", "niranjanniur04@gmail.com", "Opening float", "1234.00");

        cashList.add(cashManagementPOJO1);
        cashList.add(cashManagementPOJO2);
        cashList.add(cashManagementPOJO3);

        cashListAdapter = new CashManagementAdapter(cashList, getActivity());
        recyclerViewProductList.setAdapter(cashListAdapter);

          /* Cash Management adapter list*/
        btnAddcash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_add_cash);
                // Set dialog title
                dialog.setTitle("Add Cash");

                dialog.getWindow().setLayout((5 * width) / 7, (3 * height) / 5);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);

                // set values for custom dialog components - text, image and button

                dialog.show();
            }
        });

        btnRemovecash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_remove_cash);
                // Set dialog title
                dialog.setTitle("Remove Cash");

                dialog.getWindow().setLayout((5 * width) / 7, (3 * height) / 5);

                dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);


                // set values for custom dialog components - text, image and button

                dialog.show();
            }
        });

        return v;
    }
}

