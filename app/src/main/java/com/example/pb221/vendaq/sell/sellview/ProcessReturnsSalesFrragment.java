package com.example.pb221.vendaq.sell.sellview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pb221.vendaq.R;

/**
 * Created by pb221 on 31-10-2017.
 */

public class ProcessReturnsSalesFrragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_continous_sales_sale_history, null);

        return v;
    }
}