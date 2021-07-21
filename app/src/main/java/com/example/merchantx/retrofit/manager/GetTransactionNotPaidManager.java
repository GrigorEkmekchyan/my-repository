package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.retrofit.response.GetTransactionNotPaidResponse;
import com.example.merchantx.retrofit.response.GetTransactionOnlyPaidResponse;
import com.example.merchantx.servises.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetTransactionNotPaidManager {

    public static void searchGetTransactionNotPaidManager (final OnGetTransactionNotPaidSearchListener onGetTransactionNotPaidSearchListener, Integer id) {

        Call<GetTransactionNotPaidResponse> regModelCall = RetrofitClient.getInstance().getApiCall().getTransactionNotPaidCall(id);
        regModelCall.enqueue(new Callback<GetTransactionNotPaidResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetTransactionNotPaidResponse> call, @NonNull Response<GetTransactionNotPaidResponse> response) {

                if (response.isSuccessful()) {
                    onGetTransactionNotPaidSearchListener.onGetTransactionNotPaidSearchSuccess(response.body());

                } else onGetTransactionNotPaidSearchListener.onGetTransactionNotPaidSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<GetTransactionNotPaidResponse> call, @NonNull Throwable t) {
                onGetTransactionNotPaidSearchListener.onGetTransactionNotPaidSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnGetTransactionNotPaidSearchListener {

        void onGetTransactionNotPaidSearchSuccess(GetTransactionNotPaidResponse getTransactionNotPaidResponse);

        void onGetTransactionNotPaidSearchFail(String failMassage);

        void onGetTransactionNotPaidSearchError(String errorMassage);

    }
}
