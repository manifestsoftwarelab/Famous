package com.example.pb221.vendaq.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.pb221.vendaq.R;
import com.example.pb221.vendaq.main.uihelper.CustomProgressDialog;

/**
 * Created by DELL on 12/2/2017.
 */

public class BaseActivity extends AppCompatActivity implements IDataObserver {
    public CustomProgressDialog customProgressDialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setTitle(String title) {

    }

    @Override
    public void onDataAvailable(String data) {

    }

    @Override
    public void showDelayIndicator() {
        if (customProgressDialog == null) {
            customProgressDialog = new CustomProgressDialog(this);
        }

        customProgressDialog.setMessage(getResources().getString(R.string.delay_ind_retrieving_data));
        customProgressDialog.setCancelable(false);
        customProgressDialog.show();

    }

    @Override
    public void showErrorView(String errorMsg) {

    }

    @Override
    public void hideDelayIndicator() {
        if (customProgressDialog != null && customProgressDialog.isShowing())
            customProgressDialog.dismiss();
    }

    @Override
    public void grtStringFromId(int resId, String... name) {

    }
}
