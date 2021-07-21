package com.example.merchantx.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.bady.SendSmsBody;
import com.example.merchantx.retrofit.manager.LoginManager;
import com.example.merchantx.retrofit.manager.SendSmsManager;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.retrofit.response.SendSmsResponse;


public class SendSmsRepository implements SendSmsManager.OnSendSmsSearchListener {
    private MutableLiveData<SendSmsResponse> liveData = new MutableLiveData();
    private MutableLiveData<String> failLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public void searchSendSmsCall(SendSmsBody sendSmsBody){
        SendSmsManager.searchSendSmsManager(this, sendSmsBody);
    }

    @Override
    public void onSendSmsSearchSuccess(SendSmsResponse sendSmsResponse) {
        liveData.setValue(sendSmsResponse);
    }

    @Override
    public void onSendSmsSearchFail (String failMassage) {
       failLiveData.setValue(failMassage);
    }

    @Override
    public void onSendSmsSearchError(String errorMassage) {

    }

    public MutableLiveData<SendSmsResponse> getLiveData() {
        return liveData;
    }


    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
