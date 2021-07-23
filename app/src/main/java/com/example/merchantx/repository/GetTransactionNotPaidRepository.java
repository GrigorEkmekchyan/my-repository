package com.example.merchantx.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.merchantx.retrofit.manager.GetTransactionNotPaidManager;
import com.example.merchantx.retrofit.response.GetTransactionNotPaidResponse;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;

import java.util.List;


public class GetTransactionNotPaidRepository implements GetTransactionNotPaidManager.OnGetTransactionNotPaidSearchListener {
    private MutableLiveData<List<GetTransactionsResponse>> liveData = new MutableLiveData();
    private MutableLiveData<String> failLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public void searchGetTransactionNotPaidCall(Integer id){
        GetTransactionNotPaidManager.searchGetTransactionNotPaidManager(this, id);
    }

    @Override
    public void onGetTransactionNotPaidSearchSuccess(List<GetTransactionsResponse> getTransactionNotPaidResponse) {
        liveData.setValue(getTransactionNotPaidResponse);
    }

    @Override
    public void onGetTransactionNotPaidSearchFail (String failMassage) {
       failLiveData.setValue(failMassage);
    }

    @Override
    public void onGetTransactionNotPaidSearchError(String errorMassage) {

    }

    public MutableLiveData<List<GetTransactionsResponse>> getLiveData() {
        return liveData;
    }


    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
