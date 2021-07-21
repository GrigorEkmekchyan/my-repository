package com.example.merchantx.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.merchantx.retrofit.manager.GetTransactionOnlyPaidManager;
import com.example.merchantx.retrofit.manager.GetTransactionReversedManager;
import com.example.merchantx.retrofit.response.GetTransactionOnlyPaidResponse;
import com.example.merchantx.retrofit.response.GetTransactionReversedResponse;


public class GetTransactionReversedRepository implements GetTransactionReversedManager.OnGetTransactionReversedSearchListener {
    private MutableLiveData<GetTransactionReversedResponse> liveData = new MutableLiveData();
    private MutableLiveData<String> failLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public void searchGetTransactionReversedCall(Integer id){
        GetTransactionReversedManager.searchGetTransactionReversedManager(this, id);
    }

    @Override
    public void onGetTransactionReversedSearchSuccess(GetTransactionReversedResponse getTransactionReversedResponse) {
        liveData.setValue(getTransactionReversedResponse);
    }

    @Override
    public void onGetTransactionReversedSearchFail (String failMassage) {
       failLiveData.setValue(failMassage);
    }

    @Override
    public void onGetTransactionReversedSearchError(String errorMassage) {

    }

    public MutableLiveData<GetTransactionReversedResponse> getLiveData() {
        return liveData;
    }


    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
