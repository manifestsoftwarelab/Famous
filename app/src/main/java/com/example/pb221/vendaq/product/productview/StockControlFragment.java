package com.example.pb221.vendaq.product.productview;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.BaseActivity;
import com.example.pb221.vendaq.main.BaseFragment;
import com.example.pb221.vendaq.main.DatabaseHelper;
import com.example.pb221.vendaq.main.MyApplication;
import com.example.pb221.vendaq.main.WebCallFragment;
import com.example.pb221.vendaq.product.productadapter.BrandAdapter;
import com.example.pb221.vendaq.product.productadapter.StockControlAdapter;
import com.example.pb221.vendaq.product.productmodel.OutletsPOJONew;
import com.example.pb221.vendaq.product.productmodel.StockControlPOJO;
import com.example.pb221.vendaq.product.productmodel.SupplierPOJO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.example.pb221.vendaq.main.utils.Utils.addStock;
import static com.example.pb221.vendaq.main.utils.Utils.getBrands;
import static com.example.pb221.vendaq.main.utils.Utils.getStockControl;

/**
 * Created by pb221 on 29-10-2017.
 */

public class StockControlFragment extends BaseFragment {

    public StockControlAdapter stockControlListAdapter;
    private List<StockControlPOJO> stockControlPOJOList;
    private RecyclerView recyclerViewProductList;
    private Button btnAddStock;
    private Button btnRemoveStock;
    private Button btnTransferStock;
    DatabaseHelper DB;
    public String result = "";
    private List<SupplierPOJO> supplierList;
    EditText deliveryDue;
    final Calendar calender = Calendar.getInstance();

    final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calender.set(Calendar.YEAR, year);
            calender.set(Calendar.MONTH, monthOfYear);
            calender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stock_control, null);
        recyclerViewProductList = (RecyclerView) v.findViewById(R.id.recyclerViewProductList);
        DB = MyApplication.getInstance(getActivity());

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

        sendJsonToWebService("1");



/* product adapter list*/
/*
        StockControlPOJO listPOJO = new StockControlPOJO("Order-Thu 12 Oct 2017", "Supplier order", "12 Oct 2017", "09 Oct 2017", "MAI-4", "Maain Outlet", "No Name", "Open", "0", "Rs 0.00");
        StockControlPOJO listPOJO1 = new StockControlPOJO("Order-Thu 12 Oct 2017", "Supplier order", "12 Oct 2017", "-", "MAI-4", "Maain Outlet", "No Name", "Open", "0", "Rs 0.00");
        StockControlPOJO listPOJO2 = new StockControlPOJO("Order-Thu 12 Oct 2017", "Supplier order", "12 Oct 2017", "09 Oct 2017", "MAI-4", "Maain Outlet", "No Name", "Open", "0", "Rs 0.00");
        StockControlPOJO listPOJO3 = new StockControlPOJO("Order-Thu 12 Oct 2017", "Supplier order", "12 Oct 2017", "-", "MAI-4", "Maain Outlet", "No Name", "Open", "0", "Rs 0.00");

        stockControlPOJOList.add(listPOJO);
        stockControlPOJOList.add(listPOJO1);
        stockControlPOJOList.add(listPOJO2);
        stockControlPOJOList.add(listPOJO3);

*/


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

                final Spinner spinner1 = (Spinner) dialog.findViewById(R.id.spinner1);
                final Spinner spinner2 = (Spinner) dialog.findViewById(R.id.spinner2);
                final Spinner spinner3 = (Spinner) dialog.findViewById(R.id.spinner3);
                Button btnCancel = (Button) dialog.findViewById(R.id.Button03);
                Button btnSave = (Button) dialog.findViewById(R.id.Button04);
                final EditText nameEditText =  (EditText) dialog.findViewById(R.id.nameEditText);
                deliveryDue =  (EditText) dialog.findViewById(R.id.deliveryDueEditText);
                final EditText orderNoEditText =  (EditText) dialog.findViewById(R.id.orderNoEditText);
                final EditText supplierEditText =  (EditText) dialog.findViewById(R.id.supplierInvoiceEditText);

                SimpleDateFormat df = new SimpleDateFormat("EEE dd MMM yyyy");
                String formattedDate = df.format(calender.getTime());

                String name = "Order-" + formattedDate;
                nameEditText.setText(name, TextView.BufferType.EDITABLE);

                deliveryDue.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        new DatePickerDialog(getActivity(), date, calender
                                .get(Calendar.YEAR), calender.get(Calendar.MONTH),
                                calender.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String storeId = "1";
                        String userId = "1";
                        String name = nameEditText.getText().toString();
                        String date = deliveryDue.getText().toString();
                        String orderFrom = spinner1.getSelectedItem().toString();
                        String orderNo = orderNoEditText.getText().toString();
                        String deliverTo = spinner2.getSelectedItem().toString();
                        String supplierInvoice = supplierEditText.getText().toString();
                        String autoFill = spinner3.getSelectedItem().toString();

                        if ((name != null && !name.isEmpty()) && (date != null && !date.isEmpty()) && (orderFrom != null && !orderFrom.isEmpty()) && (orderNo != null && !orderNo.isEmpty()) && (deliverTo != null && !deliverTo.isEmpty()) && (supplierInvoice != null && !supplierInvoice.isEmpty()) && (autoFill != null && !autoFill.isEmpty())) {
                            sendStock(userId, name, date, orderFrom, orderNo, deliverTo, supplierInvoice, autoFill, storeId);
                            dialog.dismiss();
                        }
                        else
                        {
                            showAlert("All fields required","");
                        }


                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

               // String[] values = getActivity().getResources().getStringArray(R.array.spinner_array);

                supplierList = DB.getAllTableDetails( "");
                ArrayList<String> supplierNameList = new ArrayList<String>();
                for(SupplierPOJO supplier : supplierList)
                {supplierNameList.add(supplier.getSupplierName());}

                ArrayAdapter<String> supplierAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, supplierNameList);
                supplierAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner1.setAdapter(supplierAdapter);


                List<OutletsPOJONew> outletList = DB.getAllOutletsInProductList("");
                ArrayList<String> outletNameArray = new ArrayList<String>();
                for(OutletsPOJONew outletPOJO : outletList)
                {outletNameArray.add(outletPOJO.getOutletName());}

                ArrayAdapter<String> outletAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, outletNameArray);
                outletAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner2.setAdapter(outletAdapter);


                String[] autoFillOptions = {"Auto fill from reorder point","Don't auto fill"};
                ArrayAdapter<String> autofillAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, autoFillOptions);
                autofillAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner3.setAdapter(autofillAdapter);


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
                dialog.setContentView(R.layout.dialog_new_stock_transfer);
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



    private void sendJsonToWebService(String storeId) {

        final JSONObject job = new JSONObject();

        try {
            job.put(getResources().getString(R.string.str_key_storeid), storeId);


            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(getStockControl, job.toString());
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

            DB.deleteFromStockControl();

            for (int i = 0; i < jarr.length(); i++) {
                innerJob = jarr.getJSONObject(i);

                DB.insertIntoStockControl(
                        innerJob.getString("StockId"),
                        innerJob.getString("StockName"),
                        innerJob.getString("UserId"),
                        innerJob.getString( "StockType"),
                        innerJob.getString("Date"),
                        innerJob.getString("DeliveryDate"),
                        innerJob.getString("Number"),
                        innerJob.getString("Outlet"),
                        innerJob.getString("Source"),
                        innerJob.getString("Status"),
                        innerJob.getString("Items"),
                        innerJob.getString("TotalCost"),
                        innerJob.getString("SKU"),
                        innerJob.getString("Handle"),
                        innerJob.getString("SupplierCode")
                );

            }

            stockControlPOJOList = DB.getAllStockDetails("");

            stockControlListAdapter = new StockControlAdapter(stockControlPOJOList, getActivity());
            recyclerViewProductList.setAdapter(stockControlListAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void updateLabel() {
        String myFormat = "dd MMMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        deliveryDue.setText(sdf.format(calender.getTime()));
    }

    private void sendStock(String UserID,String StockName,String DeliveryDue,String OrderFrom,String OrderNo,String DeliverTo,String SupplierInvoice,String AutoFill, String storeId)
    {
        final JSONObject job = new JSONObject();

        try {
            job.put(getResources().getString(R.string.str_key_store_id), storeId);
            job.put(getResources().getString(R.string.str_key_userId), UserID);
            job.put(getResources().getString(R.string.str_key_stockName), StockName);
            job.put(getResources().getString(R.string.str_key_deliveryDue), DeliveryDue);
            job.put(getResources().getString(R.string.str_key_orderFrom), OrderFrom);
            job.put(getResources().getString(R.string.str_key_orderNo), OrderNo);
            job.put(getResources().getString(R.string.str_key_deliverTo), DeliverTo);
            job.put(getResources().getString(R.string.str_key_supplierInvoice), SupplierInvoice);
            job.put(getResources().getString(R.string.str_key_autoFill), AutoFill);


            if (android.os.Build.VERSION.SDK_INT > 9) {

                result = WebCallFragment.execute(addStock, job.toString());
                Log.e("**result IN SU*", result + "");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
