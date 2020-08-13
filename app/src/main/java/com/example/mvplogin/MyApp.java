package com.example.mvplogin;

import android.app.Application;

import com.example.mvplogin.network.ApiClient;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化WanAndroidApi
        ApiClient.apiClient.createRetrofit();
    }

}
