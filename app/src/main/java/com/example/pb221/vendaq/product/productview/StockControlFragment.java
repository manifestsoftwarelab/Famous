package com.example.pb221.vendaq.product.productview;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.product.productadapter.StockControlAdapter;
import com.example.pb221.vendaq.product.productmodel.StockControlPOJO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb221 on 29-10-2017.
 */

public class StockControlFragment extends Fragment {

    public StockControlAdapter stockControlListAdapter;
    private List<StockControlPOJO> stockControlPOJOList;
    private RecyclerView recyclerViewProductList;
    private Button btnAddStock;
    private Button btnRemoveStock;
    private Button btnTransferStock;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stock_control, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        btnAddStock = (Button) v.findViewById(R.id.btnAddStock);
        btnRemoveStock = (Button) v.findViewById(R.id.btnRemoveStock);
        btnTransferStock = (Button) v.findViewById(R.id.btnTransferStock);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewProductList.setLayoutManager(llm);


        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;

        stockControlPOJOList = new ArrayList<>();

        getActivity().setTitle("Stock Control");
/* product adapter list*/

        StockControlPOJO listPOJO = new StockControlPOJO("Order-Thu 12 Oct 2017", "Supplier order", "12 Oct 2017", "09 Oct 2017", "MAI-4", "Maain Outlet", "No Name", "Open", "0", "Rs 0.00");
        StockControlPOJO listPOJO1 = new StockControlPOJO("Order-Thu 12 Oct 2017", "Supplier order", "12 Oct 2017", "-", "MAI-4", "Maain Outlet", "No Name", "Open", "0", "Rs 0.00");
        StockControlPOJO listPOJO2 = new StockControlPOJO("Order-Thu 12 Oct 2017", "Supplier order", "12 Oct 2017", "09 Oct 2017", "MAI-4", "Maain Outlet", "No Name", "Open", "0", "Rs 0.00");
        StockControlPOJO listPOJO3 = new StockControlPOJO("Order-Thu 12 Oct 2017", "Supplier order", "12 Oct 2017", "-", "MAI-4", "Maain Outlet", "No Name", "Open", "0", "Rs 0.00");

        stockControlPOJOList.add(listPOJO);
        stockControlPOJOList.add(listPOJO1);
        stockControlPOJOList.add(listPOJO2);
        stockControlPOJOList.add(listPOJO3);


        stockControlListAdapter = new StockControlAdapter(stockControlPOJOList, getActivity());
        recyclerViewProductList.setAdapter(stockControlListAdapter);

        /* product adapter list*/
        btnAddStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create custom dialog object
                final Dialog dialog = new Dialog(getActivity());
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_add_stock);
                // Set dialog title
                dialog.setTitle("Add Stock");
                dialog.getWindow().setLayout((5 * width) / 7, (3 * height) / 5);

                dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);

                Spinner spinner1 = (Spinner) dialog.findViewById(R.id.spinner1);
                Spinner spinner2 = (Spinner) dialog.findViewById(R.id.spinner2);
                Spinner spinner3 = (Spinner) dialog.findViewById(R.id.spinner3);
                Button btnCancel = (Button) dialog.findViewById(R.id.Button03);
                Button btnSave = (Button) dialog.findViewById(R.id.Button04);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                String[] values = getActivity().getResources().getStringArray(R.array.spinner_array);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner1.setAdapter(adapter);
                spinner2.setAdapter(adapter);
                spinner3.setAdapter(adapter);


                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                // set values for custom dialog components - text, image and button

                dialog.show();

            }
        });
        btnRemoveStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_remove_stock);
                // Set dialog title

                dialog.getWindow().setLayout((5 * width) / 7, (3 * height) / 5);


                dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);

                Spinner spinner1 = (Spinner) dialog.findViewById(R.id.spinner1);
                Spinner spinner2 = (Spinner) dialog.findViewById(R.id.spinner2);

                Button btnCancel = (Button) dialog.findViewById(R.id.Button03);
                Button btnSave = (Button) dialog.findViewById(R.id.Button04);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                String[] values = getActivity().getResources().getStringArray(R.array.spinner_array);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner1.setAdapter(adapter);
                spinner2.setAdapter(adapter);


                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                dialog.show();
            }
        });
        btnTransferStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_new_price_book);
                // Set dialog title
                dialog.setTitle("New Stock Transfer");

                dialog.getWindow().setLayout((5 * width) / 7, (3 * height) / 5);


                dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);

                Spinner spinner1 = (Spinner) dialog.findViewById(R.id.spinner1);
                Spinner spinner2 = (Spinner) dialog.findViewById(R.id.spinner2);

                Button btnCancel = (Button) dialog.findViewById(R.id.Button03);
                Button btnSave = (Button) dialog.findViewById(R.id.Button04);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                String[] values = getActivity().getResources().getStringArray(R.array.spinner_array);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner1.setAdapter(adapter);
                spinner2.setAdapter(adapter);


                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                // set values for custom dialog components - text, image and button

                dialog.show();
            }
        });


        Spinner spinner1 = (Spinner) v.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) v.findViewById(R.id.spinner3);


        String[] values = getActivity().getResources().getStringArray(R.array.spinner_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return v;
    }
}
