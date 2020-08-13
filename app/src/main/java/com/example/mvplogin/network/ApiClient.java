package com.example.mvplogin.network;

import android.util.Log;

import com.example.mvplogin.api.WanAndroidApi;


import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    final static String BaseUrl = "https://www.wanandroid.com/";

    /**
     * 单例
     */
    public  static  ApiClient apiClient = new ApiClient();


    /**
     * 统一对外接口,需要调用createRetrofit后才能使用
     */
   public WanAndroidApi wanAndroidApiService;

    private ApiClient(){};


    /**
     * 自定义过滤器,返回HTTPClient对象
     * @return 返回OkHttpClient对象
     */
    private OkHttpClient getOkHttpClient() {
        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

            @Override
            public void log(String message) {
                Log.d("MainActivity","OkHttp====Message:"+message);
            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient
                .Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }

    /**
     *
     * @return 得到retrofit对象
     */
    public Retrofit createRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient();
        //List<Interceptor> interceptors = okHttpClient.networkInterceptors();
        //new OkHttpClient.Builder().addInterceptor(Http).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseUrl).client(getOkHttpClient()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        wanAndroidApiService = retrofit.create(WanAndroidApi.class);
        return retrofit;
    }



}
