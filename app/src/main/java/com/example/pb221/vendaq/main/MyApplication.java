package com.example.pb221.vendaq.main;

import android.app.Application;
import android.content.Context;

/**
 * Created by Manifest on 12/9/2017.
 */

public class MyApplication extends Application {

   static DatabaseHelper DB;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static DatabaseHelper getInstance(Context con) {

        if (DB == null) {
            DB = new DatabaseHelper(con);
        }
        return DB;
    }
}
