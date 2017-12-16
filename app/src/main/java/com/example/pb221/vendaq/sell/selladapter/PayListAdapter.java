package com.example.pb221.vendaq.sell.selladapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.sellmodel.PayModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nilesh on 04-11-2017.
 */

public class PayListAdapter extends RecyclerView.Adapter<PayListAdapter.PayViewHolder> {
    private List<PayModel> payModelList = new ArrayList<>();
    private Context mContext;

    public PayListAdapter(Context context, List<PayModel> productmodelList) {
        mContext = context;
        this.payModelList = productmodelList;
    }

    @Override
    public PayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_payrow, parent, false);
        return new PayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PayViewHolder holder, int position) {

        holder.productname.setText(String.valueOf(payModelList.get(position).getPayTitle()));
        holder.productprice.setText("$ "+String.valueOf(payModelList.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return payModelList.size();
    }

    protected class PayViewHolder extends RecyclerView.ViewHolder {
         TextView productname, productprice;

        public PayViewHolder(View itemView) {
            super(itemView);
            productname = (TextView) itemView.findViewById(R.id.totalpricetitle);
            productprice = (TextView) itemView.findViewById(R.id.totalprice);
        }
    }
}
