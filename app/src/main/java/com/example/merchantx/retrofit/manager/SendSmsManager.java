package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.bady.SendSmsBody;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.retrofit.response.SendSmsResponse;
import com.example.merchantx.servises.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SendSmsManager {

    public static void searchSendSmsManager (final OnSendSmsSearchListener onSendSmsSearchListener, SendSmsBody sendSmsBody) {

        Call<SendSmsResponse> regModelCall = RetrofitClient.getInstance().getApiCall().sendSmsCall(sendSmsBody);
        regModelCall.enqueue(new Callback<SendSmsResponse>() {
            @Override
            public void onResponse(@NonNull Call<SendSmsResponse> call, @NonNull Response<SendSmsResponse> response) {

                if (response.isSuccessful()) {
                    onSendSmsSearchListener.onSendSmsSearchSuccess(response.body());

                } else onSendSmsSearchListener.onSendSmsSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<SendSmsResponse> call, @NonNull Throwable t) {
                onSendSmsSearchListener.onSendSmsSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnSendSmsSearchListener {

        void onSendSmsSearchSuccess(SendSmsResponse sendSmsResponse);

        void onSendSmsSearchFail(String failMassage);

        void onSendSmsSearchError(String errorMassage);

    }
}
