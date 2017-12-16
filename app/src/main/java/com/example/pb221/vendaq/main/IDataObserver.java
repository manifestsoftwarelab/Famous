package com.example.pb221.vendaq.main;

/**
 * Created by DELL on 12/2/2017.
 */

public interface IDataObserver   {
   void onDataAvailable(String data);
   void showDelayIndicator();
   void showErrorView(String errorMsg);
   void hideDelayIndicator();
   void grtStringFromId(int resId, String... name);
}
