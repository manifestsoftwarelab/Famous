package com.example.pb221.vendaq.sell.selladapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.sellmodel.SalesHistoryPOJO;

import java.util.List;

/**
 * Created by pb221 on 04-11-2017.
 */

public class SalesHistoryAdapter extends
        RecyclerView.Adapter<SalesHistoryAdapter.MyViewHolder> {

    private List<SalesHistoryPOJO> productList;
    private int flag = 0;
    private Context mContext;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRowItemdate;
        public TextView tvRowItemReciept;
        public TextView tvRowItemSoldBy;
        public TextView tvRowItemCustomer;
        public TextView tvRowItemNote;
        public TextView tvRowItemSaleTotal;
        public TextView tvRowItemStatus;
        private LinearLayout layoutExpandable;

        public MyViewHolder(View view) {
            super(view);
            tvRowItemdate = (TextView) view.findViewById(R.id.tvRowItemdate);
            tvRowItemReciept = (TextView) view.findViewById(R.id.tvRowItemReciept);
            tvRowItemSoldBy = (TextView) view.findViewById(R.id.tvRowItemSoldBy);
            tvRowItemCustomer = (TextView) view.findViewById(R.id.tvRowItemCustomer);
            tvRowItemNote = (TextView) view.findViewById(R.id.tvRowItemNote);
            tvRowItemSaleTotal = (TextView) view.findViewById(R.id.tvRowItemSaleTotal);
            tvRowItemStatus = (TextView) view.findViewById(R.id.tvRowItemStatus);
            layoutExpandable = (LinearLayout) view.findViewById(R.id.layoutExpandable);

            tvRowItemdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (
                            layoutExpandable.getVisibility() == View.GONE)
                        layoutExpandable.setVisibility(View.VISIBLE);

                    else
                        layoutExpandable.setVisibility(View.GONE);

                    Log.e("*******", "in on click");

                }
            });
            tvRowItemSoldBy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("*******", "in on click");
                    if (
                            layoutExpandable.getVisibility() == View.GONE)
                        layoutExpandable.setVisibility(View.VISIBLE);

                    else
                        layoutExpandable.setVisibility(View.GONE);
                }
            });

        }

    }

    public SalesHistoryAdapter(List<SalesHistoryPOJO> productList, Context con) {
        this.productList = productList;
        mContext = con;
    }

    @Override
    public void onBindViewHolder(SalesHistoryAdapter.MyViewHolder holder, int position) {
        SalesHistoryPOJO pList = productList.get(position);
        holder.tvRowItemCustomer.setText(pList.getCustomer());
        holder.tvRowItemdate.setText(pList.getDate());
        holder.tvRowItemNote.setText(pList.getNote());
        holder.tvRowItemReciept.setText(pList.getReciept());
        holder.tvRowItemSaleTotal.setText(pList.getSaleotal() + "");
        holder.tvRowItemSoldBy.setText(pList.getSold_by() + "");
        holder.tvRowItemStatus.setText(pList.getStatus() + "");


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public SalesHistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_continous_sales, parent, false);
        return new SalesHistoryAdapter.MyViewHolder(v);


    }
}
