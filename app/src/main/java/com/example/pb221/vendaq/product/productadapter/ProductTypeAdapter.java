package com.example.pb221.vendaq.product.productadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.product.productmodel.ProductTypePOJO;

import java.util.List;

/**
 * Created by pb221 on 29-10-2017.
 */

public class ProductTypeAdapter extends
        RecyclerView.Adapter<ProductTypeAdapter.MyViewHolder> {

    private List<ProductTypePOJO> producTypetList;
    private Context mContext;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemProductName;
        public TextView tvItemNoOfProducts;

        public MyViewHolder(View view) {
            super(view);
            tvItemProductName = (TextView) view.findViewById(R.id.tvItemProductName);
            tvItemNoOfProducts = (TextView) view.findViewById(R.id.tvItemNoOfProducts);


        }
    }

    public ProductTypeAdapter(List<ProductTypePOJO> producTypetList, Context con) {
        this.producTypetList = producTypetList;
        mContext = con;
    }

    @Override
    public void onBindViewHolder(ProductTypeAdapter.MyViewHolder holder, int position) {
        ProductTypePOJO pList = producTypetList.get(position);

        Log.e("****", "" + pList.getProductTypeName());
        Log.e("****", "" + pList.getProductNoOfProduct());
        holder.tvItemProductName.setText(pList.getProductTypeName());
        holder.tvItemNoOfProducts.setText(pList.getProductNoOfProduct());


    }

    @Override
    public int getItemCount() {
        return producTypetList.size();
    }

    @Override
    public ProductTypeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_prodduct_tags_type, parent, false);
        return new ProductTypeAdapter.MyViewHolder(v);


    }
}
