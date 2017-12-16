package com.example.pb221.vendaq.sell.selladapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.sellmodel.CashManagementPOJO;

import java.util.List;

/**
 * Created by pb221 on 28-10-2017.
 */

public class CashManagementAdapter extends
        RecyclerView.Adapter<CashManagementAdapter.MyViewHolder> {

    private List<CashManagementPOJO> cashList;
    private Context con;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemTime;
        public TextView tvItemManagerName;
        public TextView tvItemReasons;
        public TextView tvItemEmail;
        public TextView tvItemTransaction;

        public MyViewHolder(View view) {
            super(view);
            tvItemTime = (TextView) view.findViewById(R.id.tvItemTime);
            tvItemManagerName = (TextView) view.findViewById(R.id.tvItemManagerName);
            tvItemEmail = (TextView) view.findViewById(R.id.tvItemEmail);
            tvItemReasons = (TextView) view.findViewById(R.id.tvItemReasons);
            tvItemTransaction = (TextView) view.findViewById(R.id.tvItemTransaction);


        }
    }

    public CashManagementAdapter(List<CashManagementPOJO> cashList, Context con) {
        this.cashList = cashList;
        con = con;
    }

    @Override
    public void onBindViewHolder(CashManagementAdapter.MyViewHolder holder, int position) {


        CashManagementPOJO pList = cashList.get(position);
        holder.tvItemTime.setText(pList.getCashTime() + "");
        holder.tvItemManagerName.setText(pList.getCashManagerName() + "");
        holder.tvItemEmail.setText(pList.getCashManagerEmail() + "");
        holder.tvItemReasons.setText(pList.getCashReasons() + "");
        holder.tvItemTransaction.setText(pList.getCashTransactionAmount() + "");
    }

    @Override
    public int getItemCount() {
        Log.e("size", cashList.size() + "");
        return cashList.size();

    }

    @Override
    public CashManagementAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cash_management_row_item, parent, false);
        return new CashManagementAdapter.MyViewHolder(v);


    }
}