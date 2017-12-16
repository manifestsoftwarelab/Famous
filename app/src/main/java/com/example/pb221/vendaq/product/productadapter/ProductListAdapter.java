package com.example.pb221.vendaq.product.productadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.product.productmodel.ProductPOJONew;
import com.example.pb221.vendaq.product.productmodel.ProductPOJONew;

import java.util.List;

/**
 * Created by pb221 on 26-10-2017.
 */

public class ProductListAdapter extends
        RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    private List<ProductPOJONew> productList;
    private Context mContext;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProductName;
        public TextView tvProductTags;
        public TextView tvProductPrice;
        public TextView tvProductDate;
        public TextView tvProductBrand;
        public TextView tvProductSupplier;
        public TextView tvProductVarient;
        public TextView tvProductCount;

        public MyViewHolder(View view) {
            super(view);
            tvProductName = (TextView) view.findViewById(R.id.tvProductName);
            tvProductTags = (TextView) view.findViewById(R.id.tvProductTags);
            tvProductPrice = (TextView) view.findViewById(R.id.tvProductPrice);
            tvProductDate = (TextView) view.findViewById(R.id.tvProductDate);
            tvProductBrand = (TextView) view.findViewById(R.id.tvProductBrand);
            tvProductCount = (TextView) view.findViewById(R.id.tvProductCount);
            tvProductVarient = (TextView) view.findViewById(R.id.tvProductVarient);
            tvProductSupplier = (TextView) view.findViewById(R.id.tvProductSupplier);


        }
    }

    public ProductListAdapter(List<ProductPOJONew> productList, Context con) {
        this.productList = productList;
        mContext = con;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProductPOJONew pList = productList.get(position);
        holder.tvProductName.setText(pList.getName());
        holder.tvProductTags.setText(pList.getTags());
//        holder.tvProductVarient.setText(pList.getProductVarients());
        holder.tvProductBrand.setText(pList.getBrand());
        holder.tvProductCount.setText(pList.getCount() + "");
//        holder.tvProductPrice.setText(pList.getProductPrice() + "");
        holder.tvProductSupplier.setText(pList.getSupplier() + "");
        holder.tvProductDate.setText(pList.getCreatedDate() + "");


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_row_item, parent, false);
        return new MyViewHolder(v);


    }
}
