package com.example.pb221.vendaq.product.productadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pb221.vendaq.product.productmodel.PriceBooksPOJO;
import com.example.pb221.vendaq.R;

import java.util.List;

/**
 * Created by pb221 on 28-10-2017.
 */

public class PriceBookAdapter extends
        RecyclerView.Adapter<PriceBookAdapter.MyViewHolder> {

    private List<PriceBooksPOJO> priceList;
    private Context con;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemBookName;
        public TextView tvItemCustomerGroup;
        public TextView tvItemOutlet;
        public TextView tvItemValidFrom;
        public TextView tvItemValidTo;
        public TextView tvItemCreatedDate;

        public MyViewHolder(View view) {
            super(view);
            tvItemBookName = (TextView) view.findViewById(R.id.tvItemBookName);
            tvItemCustomerGroup = (TextView) view.findViewById(R.id.tvItemCustomerGroup);
            tvItemOutlet = (TextView) view.findViewById(R.id.tvItemOutlet);
            tvItemValidFrom = (TextView) view.findViewById(R.id.tvItemValidFrom);
            tvItemValidTo = (TextView) view.findViewById(R.id.tvItemValidTo);
            tvItemCreatedDate = (TextView) view.findViewById(R.id.tvItemCreatedDate);


        }
    }

    public PriceBookAdapter(List<PriceBooksPOJO> priceList, Context con) {
        this.priceList = priceList;
        con = con;
    }

    @Override
    public void onBindViewHolder(PriceBookAdapter.MyViewHolder holder, int position) {


        PriceBooksPOJO pList = priceList.get(position);
        holder.tvItemBookName.setText(pList.getPriceBookName()+"");
        holder.tvItemCustomerGroup.setText(pList.getPriceBookCustomerGroup()+"");
        holder.tvItemOutlet.setText(pList.getPriceBookOutlet()+"");
        holder.tvItemValidFrom.setText(pList.getPriceBookValidFromDate()+"");
        holder.tvItemValidTo.setText(pList.getPriceBookValidToDate()+"");
        holder.tvItemCreatedDate.setText(pList.getPriceBookCreateDate()+"");
    }

    @Override
    public int getItemCount() {
        Log.e("size",priceList.size()+"");
        return priceList.size();

    }

    @Override
    public PriceBookAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.price_book_row_item, parent, false);
        return new PriceBookAdapter.MyViewHolder(v);


    }
}