package com.example.merchantx.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.merchantx.retrofit.manager.GetTransactionReversedManager;
import com.example.merchantx.retrofit.response.GetTransactionReversedResponse;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;

import java.util.List;


public class GetTransactionReversedRepository implements GetTransactionReversedManager.OnGetTransactionReversedSearchListener {
    private MutableLiveData<List<GetTransactionsResponse>> liveData = new MutableLiveData();
    private MutableLiveData<String> failLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public void searchGetTransactionReversedCall(Integer id){
        GetTransactionReversedManager.searchGetTransactionReversedManager(this, id);
    }

    @Override
    public void onGetTransactionReversedSearchSuccess(List<GetTransactionsResponse> getTransactionReversedResponse) {
        liveData.setValue(getTransactionReversedResponse);
    }

    @Override
    public void onGetTransactionReversedSearchFail (String failMassage) {
       failLiveData.setValue(failMassage);
    }

    @Override
    public void onGetTransactionReversedSearchError(String errorMassage) {

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
