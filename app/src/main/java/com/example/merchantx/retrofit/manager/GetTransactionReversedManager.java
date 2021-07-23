package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.retrofit.response.GetTransactionReversedResponse;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;
import com.example.merchantx.servises.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetTransactionReversedManager {

    public static void searchGetTransactionReversedManager (final OnGetTransactionReversedSearchListener onGetTransactionReversedSearchListener, Integer id) {

        Call<List<GetTransactionsResponse>> regModelCall = RetrofitClient.getInstance().getApiCall().getTransactionReversedCall(id);
        regModelCall.enqueue(new Callback<List<GetTransactionsResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<GetTransactionsResponse>> call, @NonNull Response<List<GetTransactionsResponse>> response) {

                if (response.isSuccessful()) {
                    onGetTransactionReversedSearchListener.onGetTransactionReversedSearchSuccess(response.body());

                } else onGetTransactionReversedSearchListener.onGetTransactionReversedSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<List<GetTransactionsResponse>> call, @NonNull Throwable t) {
                onGetTransactionReversedSearchListener.onGetTransactionReversedSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnGetTransactionReversedSearchListener {

        void onGetTransactionReversedSearchSuccess(List<GetTransactionsResponse> getTransactionReversedResponse);

        void onGetTransactionReversedSearchFail(String failMassage);

        void onGetTransactionReversedSearchError(String errorMassage);

    }
}
