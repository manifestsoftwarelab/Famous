package com.example.pb221.vendaq.product.productadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.product.productmodel.ProductTagsPOJO;
import com.example.pb221.vendaq.product.productmodel.ProductTypePOJO;

import java.util.List;

/**
 * Created by pb221 on 29-10-2017.
 */

public class ProductTagsAdapter  extends
        RecyclerView.Adapter<ProductTagsAdapter.MyViewHolder> {
    private List<ProductTagsPOJO> producTagList;
    private Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemProductName;
        public TextView tvItemNoOfProducts;

        public MyViewHolder(View view) {
            super(view);
            tvItemProductName = (TextView) view.findViewById(R.id.tvItemProductName);
            tvItemNoOfProducts = (TextView) view.findViewById(R.id.tvItemNoOfProducts);


        }
    }

    public ProductTagsAdapter(List<ProductTagsPOJO> producTagList, Context mContext) {
        this.producTagList = producTagList;
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(ProductTagsAdapter.MyViewHolder holder, int position) {
        ProductTagsPOJO pList = producTagList.get(position);

        Log.e("****", "" + pList.getTagName());
        Log.e("****", "" + pList.getNumberOfProduct());
        holder.tvItemProductName.setText(pList.getTagName());
        holder.tvItemNoOfProducts.setText(pList.getNumberOfProduct());


    }

    @Override
    public int getItemCount() {
        return producTagList.size();
    }

    @Override
    public ProductTagsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_prodduct_tags_type, parent, false);
        return new ProductTagsAdapter.MyViewHolder(v);


    }
}
