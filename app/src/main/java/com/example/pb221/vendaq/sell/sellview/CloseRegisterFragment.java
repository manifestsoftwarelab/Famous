package com.example.pb221.vendaq.sell.sellview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.pb221.vendaq.R;

import java.util.List;

/**
 * Created by pb221 on 04-11-2017.
 */

public class CloseRegisterFragment extends Fragment {

    private LinearLayout layoutExpandableCash;
    private LinearLayout layoutExpandableClick;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_close_register, null);

        layoutExpandableCash = (LinearLayout) v.findViewById(R.id.layoutExpandableCash);
        layoutExpandableClick = (LinearLayout) v.findViewById(R.id.layoutExpandableClick);

        getActivity().setTitle("Close Register");

        layoutExpandableClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutExpandableCash.getVisibility() == View.GONE)
                {
                    layoutExpandableCash.setVisibility(View.VISIBLE);
                }
                else
                {
                    layoutExpandableCash.setVisibility(View.GONE);

                }

            }
        });
        return v;
    }
}
