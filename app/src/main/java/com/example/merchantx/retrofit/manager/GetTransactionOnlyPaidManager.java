package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;
import com.example.merchantx.servises.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetTransactionOnlyPaidManager {

    public static void searchGetTransactionOnlyPaidManager(final OnGetTransactionOnlyPaidSearchListener onGetTransactionOnlyPaidSearchListener, Integer id) {

        Call<List<GetTransactionsResponse>> regModelCall = RetrofitClient.getInstance().getApiCall().getTransactionOnlyPaidCall(id);
        regModelCall.enqueue(new Callback<List<GetTransactionsResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<GetTransactionsResponse>> call, @NonNull Response<List<GetTransactionsResponse>>response) {

                if (response.isSuccessful()) {
                    onGetTransactionOnlyPaidSearchListener.onGetTransactionOnlyPaidSearchSuccess(response.body());

                } else
                    onGetTransactionOnlyPaidSearchListener.onGetTransactionOnlyPaidSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<List<GetTransactionsResponse>> call, @NonNull Throwable t) {
                onGetTransactionOnlyPaidSearchListener.onGetTransactionOnlyPaidSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnGetTransactionOnlyPaidSearchListener {

        void onGetTransactionOnlyPaidSearchSuccess(List<GetTransactionsResponse> getTransactionsResponse);

        void onGetTransactionOnlyPaidSearchFail(String failMassage);

        void onGetTransactionOnlyPaidSearchError(String errorMassage);

    }
}
