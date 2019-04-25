package com.example.android.youtubesearch;

import android.app.Application;

import com.example.android.youtubesearch.Database.MyDataBase;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyDataBase.init(this);
    }
}
