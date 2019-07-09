package com.baiwei.lib_network.utlis;

import com.baiwei.lib_network.api.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrfigManager {

    private static volatile RetrfigManager retrfigManager;

    private OkHttpClient mClient;

    private Retrofit mRetrofit;

    private RetrfigManager(){
        inintRetrofigManager();
    }

    private void inintRetrofigManager() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(20 , TimeUnit.SECONDS);
        builder.readTimeout(20 , TimeUnit.SECONDS);
        builder.writeTimeout(20 , TimeUnit.SECONDS);
        mClient = builder.build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .client(mClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T reCreat(Class<T> service){
        return mRetrofit.create(service);
    }
    public static RetrfigManager getInstance(){
        if (retrfigManager == null){
            synchronized (RetrfigManager.class){
                if (retrfigManager == null){
                    retrfigManager = new RetrfigManager();
                }
            }
        }
        return retrfigManager;
    }



}
