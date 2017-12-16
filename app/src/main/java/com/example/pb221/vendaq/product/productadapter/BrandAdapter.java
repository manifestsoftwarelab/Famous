package com.example.pb221.vendaq.product.productadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pb221.vendaq.product.productmodel.BrandPOJO;
import com.example.pb221.vendaq.R;

import java.util.List;

/**
 * Created by pb221 on 27-10-2017.
 */

public class BrandAdapter extends
        RecyclerView.Adapter<BrandAdapter.MyViewHolder> {

    private List<BrandPOJO> brandList;
    private  Context con;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemName;
        public TextView tvItemDes;
        public TextView tvItemNoOfProduct;

        public MyViewHolder(View view) {
            super(view);
            tvItemName = (TextView) view.findViewById(R.id.tvItemName);
            tvItemDes = (TextView) view.findViewById(R.id.tvItemDes);
            tvItemNoOfProduct = (TextView) view.findViewById(R.id.tvItemNoOfProduct);


        }
    }

    public BrandAdapter(List<BrandPOJO> brandList, Context con) {
        this.brandList = brandList;
        con = con;
    }

    @Override
    public void onBindViewHolder(BrandAdapter.MyViewHolder holder, int position) {


        BrandPOJO pList = brandList.get(position);
        holder.tvItemName.setText(pList.getBrandName()+"");
        holder.tvItemDes.setText(pList.getBrandDescription()+"");
        holder.tvItemNoOfProduct.setText(pList.getNumberOfProducts()+"");
    }

    @Override
    public int getItemCount() {
        Log.e("size",brandList.size()+"");
        return brandList.size();

    }

    @Override
    public BrandAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.brand_row_item, parent, false);
        return new BrandAdapter.MyViewHolder(v);


    }
}