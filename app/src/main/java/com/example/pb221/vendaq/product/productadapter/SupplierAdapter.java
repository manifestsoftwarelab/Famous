package com.example.pb221.vendaq.product.productadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.product.productmodel.SupplierPOJO;

import java.util.List;

/**
 * Created by pb221 on 29-10-2017.
 */

public class SupplierAdapter extends
        RecyclerView.Adapter<SupplierAdapter.MyViewHolder> {

    private List<SupplierPOJO> suppliertList;
    private Context mContext;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemProductName;
        public TextView tvItemNoOfProduct;
        public TextView tvItemDescription;
        public TextView tvItemDefaultMarkup;

        public MyViewHolder(View view) {
            super(view);
            tvItemProductName = (TextView) view.findViewById(R.id.tvItemProductName);
            tvItemNoOfProduct = (TextView) view.findViewById(R.id.tvItemNoOfProduct);
            tvItemDescription = (TextView) view.findViewById(R.id.tvItemDescription);
            tvItemDefaultMarkup = (TextView) view.findViewById(R.id.tvItemDefaultMarkup);


        }
    }

    public SupplierAdapter(List<SupplierPOJO> suppliertList, Context con) {
        this.suppliertList = suppliertList;
        mContext = con;
    }

    @Override
    public void onBindViewHolder(SupplierAdapter.MyViewHolder holder, int position) {
        SupplierPOJO pList = suppliertList.get(position);

        holder.tvItemProductName.setText(pList.getSupplierName());
        holder.tvItemNoOfProduct.setText(pList.getSupplierNoOfProduct());
        holder.tvItemDescription.setText(pList.getSupplierDescription());
        holder.tvItemDefaultMarkup.setText(pList.getSupplierDefaultMarkup());


    }

    @Override
    public int getItemCount() {
        return suppliertList.size();
    }

    @Override
    public SupplierAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_supplier_list, parent, false);
        return new SupplierAdapter.MyViewHolder(v);


    }
}
