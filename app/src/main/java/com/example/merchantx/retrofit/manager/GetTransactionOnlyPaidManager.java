package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.GetTransactionOnlyPaidResponse;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.servises.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetTransactionOnlyPaidManager {

    public static void searchGetTransactionOnlyPaidManager (final OnGetTransactionOnlyPaidSearchListener onGetTransactionOnlyPaidSearchListener, Integer id) {

        Call<GetTransactionOnlyPaidResponse> regModelCall = RetrofitClient.getInstance().getApiCall().getTransactionOnlyPaidCall(id);
        regModelCall.enqueue(new Callback<GetTransactionOnlyPaidResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetTransactionOnlyPaidResponse> call, @NonNull Response<GetTransactionOnlyPaidResponse> response) {

                if (response.isSuccessful()) {
                    onGetTransactionOnlyPaidSearchListener.onGetTransactionOnlyPaidSearchSuccess(response.body());

                } else onGetTransactionOnlyPaidSearchListener.onGetTransactionOnlyPaidSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<GetTransactionOnlyPaidResponse> call, @NonNull Throwable t) {
                onGetTransactionOnlyPaidSearchListener.onGetTransactionOnlyPaidSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnGetTransactionOnlyPaidSearchListener {

        void onGetTransactionOnlyPaidSearchSuccess(GetTransactionOnlyPaidResponse getTransactionOnlyPaidResponse);

        void onGetTransactionOnlyPaidSearchFail(String failMassage);

        void onGetTransactionOnlyPaidSearchError(String errorMassage);

    }
}
