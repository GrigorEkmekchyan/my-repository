package com.example.merchantx.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.manager.LoginManager;
import com.example.merchantx.retrofit.response.LoginResponse;


public class LoginRepository implements LoginManager.OnLoginSearchListener {
    private MutableLiveData<LoginResponse> liveData = new MutableLiveData();
    private MutableLiveData<String> failLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public void searchLoginCall(LoginBody loginBody) {
        LoginManager.searchLoginManager(this, loginBody);
    }

    @Override
    public void onLoginSearchSuccess(LoginResponse loginResponse) {
        liveData.setValue(loginResponse);
    }

    @Override
    public void onLoginSearchFail(String failMassage) {
        failLiveData.setValue(failMassage);
    }

    @Override
    public void onLoginSearchError(String errorMassage) {
        errorLiveData.setValue(errorMassage);

    }

    public MutableLiveData<LoginResponse> getLiveData() {
        return liveData;
    }


    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
