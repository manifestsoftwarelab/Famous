package com.example.pb221.vendaq.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pb221.vendaq.R;

import java.util.List;

/**
 * Created by pb221 on 28-10-2017.
 */

public class DrawerOuterAdapter extends
        RecyclerView.Adapter<DrawerOuterAdapter.MyViewHolder> {

    private List<DrowerOutsidePOJO> drawerOuterList;
    private Context con;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgvwTitle;
        public TextView txtvwTitle;
        public TextView txtVwIsOpen;

        public MyViewHolder(View view) {
            super(view);
            imgvwTitle = (ImageView) view.findViewById(R.id.imgvwTitle);
            txtvwTitle = (TextView) view.findViewById(R.id.txtvwTitle);
            txtVwIsOpen = (TextView) view.findViewById(R.id.txtVwIsOpen);


        }
    }

    public DrawerOuterAdapter(List<DrowerOutsidePOJO> drawerOuterList, Context con) {
        this.drawerOuterList = drawerOuterList;
        con = con;
    }

    @Override
    public void onBindViewHolder(DrawerOuterAdapter.MyViewHolder holder, int position) {


        DrowerOutsidePOJO pList = drawerOuterList.get(position);
        holder.txtvwTitle.setText(pList.getName() + "");
        holder.txtVwIsOpen.setText(pList.isOpen() + "");
        holder.imgvwTitle.setImageResource(pList.getImg());
    }

    @Override
    public int getItemCount() {
        Log.e("size", drawerOuterList.size() + "");
        return drawerOuterList.size();

    }

    @Override
    public DrawerOuterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_list_row, parent, false);
        return new DrawerOuterAdapter.MyViewHolder(v);


    }
}