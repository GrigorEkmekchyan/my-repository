package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.base.Constants;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.servises.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginManager {

    public static void searchLoginManager (final OnLoginSearchListener onLoginSearchListener, LoginBody loginBody) {

        Call<LoginResponse> regModelCall = RetrofitClient.getInstance().getApiCall().loginCall(loginBody);
        regModelCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    Constants.TOKEN = response.headers().get("token");
                    onLoginSearchListener.onLoginSearchSuccess(response.body());

                } else onLoginSearchListener.onLoginSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                onLoginSearchListener.onLoginSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnLoginSearchListener {

        void onLoginSearchSuccess(LoginResponse loginResponse);

        void onLoginSearchFail(String failMassage);

        void onLoginSearchError(String errorMassage);

    }
}
