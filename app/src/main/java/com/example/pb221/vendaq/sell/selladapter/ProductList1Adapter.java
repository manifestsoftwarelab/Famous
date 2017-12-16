package com.example.pb221.vendaq.sell.selladapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.sell.sellmodel.Productmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nilesh on 04-11-2017.
 */

public class ProductList1Adapter extends BaseExpandableListAdapter {

    private ProductGroupViewHolder  mProductGroupHolder;
    private ProductChildViewHolder mProductChildHolder;


    private List<Productmodel> productmodelList = new ArrayList<>();
    private Context mContext;
    public ProductList1Adapter(Context mainActivity, List<Productmodel> productmodelList) {
        mContext = mainActivity;
        this.productmodelList = productmodelList;
    }

    @Override
    public int getGroupCount() {
        return productmodelList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return i;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int position, boolean b, View view, ViewGroup viewGroup) {
        if (view == null)
        {
            mProductGroupHolder = new ProductGroupViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_products_row,viewGroup,false);
            mProductGroupHolder.productquantity = (TextView) view.findViewById(R.id.productnumber);
            mProductGroupHolder.productname = (TextView) view.findViewById(R.id.productName);
            mProductGroupHolder.producttype = (TextView) view.findViewById(R.id.productType);
            mProductGroupHolder.productprice = (TextView) view.findViewById(R.id.product_price);
            mProductGroupHolder.producttype = (TextView) view.findViewById(R.id.productType);

            mProductGroupHolder.iconrightarrow = (TextView) view.findViewById(R.id.product_iconarrow);
            mProductGroupHolder.icondelete = (TextView) view.findViewById(R.id.product_deleteicon);
            view.setTag(mProductGroupHolder);

        }else {
            mProductGroupHolder = (ProductGroupViewHolder) view.getTag();
        }

        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(),
                "icomoon.ttf");
        mProductGroupHolder.productquantity.setText(String.valueOf(productmodelList.get(position).getProduct_id()));
        mProductGroupHolder.productname.setText(String.valueOf(productmodelList.get(position).getProduct_name()));
        mProductGroupHolder.producttype.setText(String.valueOf(productmodelList.get(position).getProduct_type()));
        mProductGroupHolder.productprice.setText(String.valueOf(productmodelList.get(position).getProduct_price()));

        mProductGroupHolder.iconrightarrow.setTypeface(typeface);
        mProductGroupHolder.icondelete.setTypeface(typeface);




        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null)
        {
            mProductChildHolder = new ProductChildViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.productchildrow,viewGroup,false);
            view.setTag(mProductChildHolder);
        }else {
            mProductChildHolder = (ProductChildViewHolder) view.getTag();
        }

        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(),
                "icomoon.ttf");




        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class ProductGroupViewHolder
    {
        TextView productquantity, productname, producttype, productprice;
        TextView iconrightarrow, icondelete;
    }

    class ProductChildViewHolder
    {
        TextView productquantity, productname, producttype, productprice;
        TextView iconrightarrow, icondelete;
    }
}
