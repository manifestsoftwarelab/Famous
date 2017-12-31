package com.example.pb221.vendaq.main;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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

    public void showAlert(String message, String title)
    {
        final AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
