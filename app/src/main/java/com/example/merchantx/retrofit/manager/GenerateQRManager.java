package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.retrofit.bady.GenerateQRBody;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.GenerateQRResponse;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.servises.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GenerateQRManager {

    public static void searchGenerateQRManager (final OnGenerateQRSearchListener onGenerateQRSearchListener, GenerateQRBody generateQRBody) {

        Call<GenerateQRResponse> regModelCall = RetrofitClient.getInstance().getApiCall().generateQRCall(generateQRBody);
        regModelCall.enqueue(new Callback<GenerateQRResponse>() {
            @Override
            public void onResponse(@NonNull Call<GenerateQRResponse> call, @NonNull Response<GenerateQRResponse> response) {

                if (response.isSuccessful()) {
                    onGenerateQRSearchListener.onGenerateQRSearchSuccess(response.body());

                } else onGenerateQRSearchListener.onGenerateQRSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<GenerateQRResponse> call, @NonNull Throwable t) {
                onGenerateQRSearchListener.onGenerateQRSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnGenerateQRSearchListener {

        void onGenerateQRSearchSuccess(GenerateQRResponse generateQRResponse);

        void onGenerateQRSearchFail(String failMassage);

        void onGenerateQRSearchError(String errorMassage);

    }
}
