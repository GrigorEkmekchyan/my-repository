package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.retrofit.response.GetTransactionOnlyPaidResponse;
import com.example.merchantx.retrofit.response.GetTransactionReversedResponse;
import com.example.merchantx.servises.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetTransactionReversedManager {

    public static void searchGetTransactionReversedManager (final OnGetTransactionReversedSearchListener onGetTransactionReversedSearchListener, Integer id) {

        Call<GetTransactionReversedResponse> regModelCall = RetrofitClient.getInstance().getApiCall().getTransactionReversedCall(id);
        regModelCall.enqueue(new Callback<GetTransactionReversedResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetTransactionReversedResponse> call, @NonNull Response<GetTransactionReversedResponse> response) {

                if (response.isSuccessful()) {
                    onGetTransactionReversedSearchListener.onGetTransactionReversedSearchSuccess(response.body());

                } else onGetTransactionReversedSearchListener.onGetTransactionReversedSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<GetTransactionReversedResponse> call, @NonNull Throwable t) {
                onGetTransactionReversedSearchListener.onGetTransactionReversedSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnGetTransactionReversedSearchListener {

        void onGetTransactionReversedSearchSuccess(GetTransactionReversedResponse getTransactionReversedResponse);

        void onGetTransactionReversedSearchFail(String failMassage);

        void onGetTransactionReversedSearchError(String errorMassage);

    }
}
