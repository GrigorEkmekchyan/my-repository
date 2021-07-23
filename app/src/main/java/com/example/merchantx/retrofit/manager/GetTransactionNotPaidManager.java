package com.example.merchantx.retrofit.manager;

import androidx.annotation.NonNull;

import com.example.merchantx.retrofit.response.GetTransactionNotPaidResponse;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;
import com.example.merchantx.servises.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetTransactionNotPaidManager {

    public static void searchGetTransactionNotPaidManager (final OnGetTransactionNotPaidSearchListener onGetTransactionNotPaidSearchListener, Integer id) {

        Call<List<GetTransactionsResponse> > regModelCall = RetrofitClient.getInstance().getApiCall().getTransactionNotPaidCall(id);
        regModelCall.enqueue(new Callback<List<GetTransactionsResponse> >() {
            @Override
            public void onResponse(@NonNull Call<List<GetTransactionsResponse> > call, @NonNull Response<List<GetTransactionsResponse> > response) {

                if (response.isSuccessful()) {
                    onGetTransactionNotPaidSearchListener.onGetTransactionNotPaidSearchSuccess(response.body());

                } else onGetTransactionNotPaidSearchListener.onGetTransactionNotPaidSearchFail(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<List<GetTransactionsResponse> > call, @NonNull Throwable t) {
                onGetTransactionNotPaidSearchListener.onGetTransactionNotPaidSearchError(t.getLocalizedMessage());

            }
        });
    }

    public interface OnGetTransactionNotPaidSearchListener {

        void onGetTransactionNotPaidSearchSuccess(List<GetTransactionsResponse> getTransactionNotPaidResponse);

        void onGetTransactionNotPaidSearchFail(String failMassage);

        void onGetTransactionNotPaidSearchError(String errorMassage);

    }
}
