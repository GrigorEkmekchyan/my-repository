package com.example.merchantx.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.merchantx.retrofit.manager.GetTransactionOnlyPaidManager;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;

import java.util.List;


public class GetTransactionOnlyPaidRepository implements GetTransactionOnlyPaidManager.OnGetTransactionOnlyPaidSearchListener {
    private MutableLiveData<List<GetTransactionsResponse>> liveData = new MutableLiveData();
    private MutableLiveData<String> failLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public void searchGetTransactionOnlyPaidCall(Integer id){
        GetTransactionOnlyPaidManager.searchGetTransactionOnlyPaidManager(this, id);
    }

    @Override
    public void onGetTransactionOnlyPaidSearchSuccess(List<GetTransactionsResponse> getTransactionsResponse) {
        liveData.setValue(getTransactionsResponse);
    }

    @Override
    public void onGetTransactionOnlyPaidSearchFail (String failMassage) {
       failLiveData.setValue(failMassage);
    }

    @Override
    public void onGetTransactionOnlyPaidSearchError(String errorMassage) {

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
