package com.example.merchantx.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.merchantx.retrofit.bady.SendSmsBody;
import com.example.merchantx.retrofit.manager.GetTransactionOnlyPaidManager;
import com.example.merchantx.retrofit.manager.SendSmsManager;
import com.example.merchantx.retrofit.response.GetTransactionOnlyPaidResponse;
import com.example.merchantx.retrofit.response.SendSmsResponse;


public class GetTransactionOnlyPaidRepository implements GetTransactionOnlyPaidManager.OnGetTransactionOnlyPaidSearchListener {
    private MutableLiveData<GetTransactionOnlyPaidResponse> liveData = new MutableLiveData();
    private MutableLiveData<String> failLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public void searchGetTransactionOnlyPaidCall(Integer id){
        GetTransactionOnlyPaidManager.searchGetTransactionOnlyPaidManager(this, id);
    }

    @Override
    public void onGetTransactionOnlyPaidSearchSuccess(GetTransactionOnlyPaidResponse getTransactionOnlyPaidResponse) {
        liveData.setValue(getTransactionOnlyPaidResponse);
    }

    @Override
    public void onGetTransactionOnlyPaidSearchFail (String failMassage) {
       failLiveData.setValue(failMassage);
    }

    @Override
    public void onGetTransactionOnlyPaidSearchError(String errorMassage) {

    }

    public MutableLiveData<GetTransactionOnlyPaidResponse> getLiveData() {
        return liveData;
    }


    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
