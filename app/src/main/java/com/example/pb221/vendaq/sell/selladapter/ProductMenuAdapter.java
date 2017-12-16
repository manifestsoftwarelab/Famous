package com.example.pb221.vendaq.sell.selladapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.sellmodel.ProductMenuModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nilesh on 04-11-2017.
 */

public class ProductMenuAdapter extends RecyclerView.Adapter<ProductMenuAdapter.ProductMenuHolder> {
    private List<ProductMenuModel> productmenuModelList = new ArrayList<>();
    private Context mContext;

    public ProductMenuAdapter(Context context, List<ProductMenuModel> productmodelList) {
        mContext = context;
        this.productmenuModelList = productmodelList;
    }

    @Override
    public ProductMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producttile, parent, false);
        return new ProductMenuHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductMenuHolder holder, int position) {

        holder.productname.setText(String.valueOf(productmenuModelList.get(position).getProductname()));


    }

    @Override
    public int getItemCount() {
        return productmenuModelList.size();
    }

    protected class ProductMenuHolder extends RecyclerView.ViewHolder {
         TextView productname;
         ImageView productimage;

        public ProductMenuHolder(View itemView) {
            super(itemView);
            productname = (TextView) itemView.findViewById(R.id.productname);
            productimage = (ImageView) itemView.findViewById(R.id.productimage);
        }
    }
}
