package com.example.pb221.vendaq.sell.selladapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.sellmodel.Productmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nilesh on 04-11-2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private List<Productmodel> productmodelList = new ArrayList<>();
    private Context mContext;

    public ProductListAdapter(Context context,List<Productmodel> productmodelList) {
        mContext = context;
        this.productmodelList = productmodelList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_products_row, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(),
                "icomoon.ttf");
        holder.productquantity.setText(String.valueOf(productmodelList.get(position).getProduct_id()));
        holder.productname.setText(String.valueOf(productmodelList.get(position).getProduct_name()));
        holder.producttype.setText(String.valueOf(productmodelList.get(position).getProduct_type()));
        holder.productprice.setText(String.valueOf(productmodelList.get(position).getProduct_price()));

        holder.iconrightarrow.setTypeface(typeface);
        holder.icondelete.setTypeface(typeface);

    }

    @Override
    public int getItemCount() {
        return productmodelList.size();
    }

    protected class ProductViewHolder extends RecyclerView.ViewHolder {
         TextView productquantity, productname, producttype, productprice;
         TextView iconrightarrow, icondelete;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productquantity = (TextView) itemView.findViewById(R.id.productnumber);
            productname = (TextView) itemView.findViewById(R.id.productName);
            producttype = (TextView) itemView.findViewById(R.id.productType);
            productprice = (TextView) itemView.findViewById(R.id.product_price);
            producttype = (TextView) itemView.findViewById(R.id.productType);

            iconrightarrow = (TextView) itemView.findViewById(R.id.product_iconarrow);
            icondelete = (TextView) itemView.findViewById(R.id.product_deleteicon);
        }
    }
}
