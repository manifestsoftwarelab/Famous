package com.example.pb221.vendaq.product.productadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.product.productmodel.StockControlPOJO;

import java.util.List;

/**
 * Created by pb221 on 29-10-2017.
 */

public class StockControlAdapter extends
        RecyclerView.Adapter<StockControlAdapter.MyViewHolder> {

    private List<StockControlPOJO> stockControlList;
    private Context mContext;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemName;
        public TextView tvItemType;
        public TextView tvItemDate;
        public TextView tvItemDelieveryDue;
        public TextView tvItemNumber;
        public TextView tvItemOutlet;
        public TextView tvItemSource;
        public TextView tvItemStatus;
        public TextView tvItemItems;
        public TextView tvItemTotalCost;

        public MyViewHolder(View view) {
            super(view);
            tvItemName = (TextView) view.findViewById(R.id.tvItemName);
            tvItemType = (TextView) view.findViewById(R.id.tvItemType);
            tvItemDate = (TextView) view.findViewById(R.id.tvItemDate);
            tvItemDelieveryDue = (TextView) view.findViewById(R.id.tvItemDelieveryDue);
            tvItemNumber = (TextView) view.findViewById(R.id.tvItemNumber);
            tvItemOutlet = (TextView) view.findViewById(R.id.tvItemOutlet);
            tvItemSource = (TextView) view.findViewById(R.id.tvItemSource);
            tvItemStatus = (TextView) view.findViewById(R.id.tvItemStatus);
            tvItemItems = (TextView) view.findViewById(R.id.tvItemItems);
            tvItemTotalCost = (TextView) view.findViewById(R.id.tvItemTotalCost);
        }
    }

    public StockControlAdapter(List<StockControlPOJO> stockControlList, Context con) {
        this.stockControlList = stockControlList;
        mContext = con;
    }

    @Override
    public void onBindViewHolder(StockControlAdapter.MyViewHolder holder, int position) {
        StockControlPOJO pList = stockControlList.get(position);

        holder.tvItemName.setText(pList.getStockItemDate());
        holder.tvItemType.setText(pList.getStockItemType());
        holder.tvItemDate.setText(pList.getStockItemDate());
        holder.tvItemDelieveryDue.setText(pList.getStockItemDileveryDue());
        holder.tvItemNumber.setText(pList.getStockItemNumber());
        holder.tvItemOutlet.setText(pList.getStockItemOutlet());
        holder.tvItemSource.setText(pList.getStockItemSource());
        holder.tvItemStatus.setText(pList.getStockItemStatus());
        holder.tvItemItems.setText(pList.getStockItemItems());
        holder.tvItemTotalCost.setText(pList.getStockItemTotalCost());


    }

    @Override
    public int getItemCount() {
        return stockControlList.size();
    }

    @Override
    public StockControlAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_control_item, parent, false);
        return new StockControlAdapter.MyViewHolder(v);


    }
}
