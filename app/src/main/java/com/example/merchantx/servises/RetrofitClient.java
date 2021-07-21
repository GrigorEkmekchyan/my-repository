package com.example.merchantx.servises;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.Chain;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.merchantx.base.Constants.TOKEN;


public class RetrofitClient {

    private static com.example.merchantx.servises.RetrofitClient instance;
    private static final String BASE_URL = "http://suren077-001-site1.ctempurl.com/";
    private RetrofitApiService apiCall;
    private RetrofitClient() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            @NonNull
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization","Bearer "+TOKEN)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

     //   client.interceptors().add(new HttpInterceptor());

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        apiCall = retrofit.create(RetrofitApiService.class);

    }


    public static com.example.merchantx.servises.RetrofitClient getInstance() {

        if (instance == null) {
            instance = new com.example.merchantx.servises.RetrofitClient();
        }
        return instance;

    }

    public RetrofitApiService getApiCall() {
        return apiCall;
    }
}
