package com.example.pb221.vendaq.sell.sellview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.pb221.vendaq.R;

/**
 * Created by pb221 on 05-11-2017.
 */

public class DashBoardFragment extends Fragment {
    private Button btnResetData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_reset_data, null);


        getActivity().setTitle("Status");

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;

        btnResetData = (Button) v.findViewById(R.id.btnResetData);

        btnResetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                // Include dialog.xml file
                dialog.setContentView(R.layout.reset_data);
                // Set dialog title

                dialog.getWindow().setLayout((5 * width) / 7, (3 * height) / 5);

                dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_orange_button);


                Button btnCancel = (Button) dialog.findViewById(R.id.Button06);
                Button btnSave = (Button) dialog.findViewById(R.id.Button05);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        return v;
    }
}