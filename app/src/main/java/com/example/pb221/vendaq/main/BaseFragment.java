package com.example.pb221.vendaq.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.uihelper.CustomProgressDialog;

/**
 * Created by DELL on 12/2/2017.
 */

public class BaseFragment extends Fragment implements IDataObserver {
    public CustomProgressDialog customProgressDialog = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return null;
    }



    @Override
    public void onDataAvailable(String data) {

    }

    @Override
    public void showDelayIndicator() {
        if (customProgressDialog == null) {
            customProgressDialog = new CustomProgressDialog(getActivity());
        }

        customProgressDialog.setMessage(getResources().getString(R.string.delay_ind_retrieving_data));
        customProgressDialog.setCancelable(false);
        customProgressDialog.show();

    }

    @Override
    public void showErrorView(String errorMsg) {

    }

    public void hideDelayIndicator() {
        if (customProgressDialog != null && customProgressDialog.isShowing())
            customProgressDialog.dismiss();
    }

    @Override
    public void grtStringFromId(int resId, String... name) {

    }


}
