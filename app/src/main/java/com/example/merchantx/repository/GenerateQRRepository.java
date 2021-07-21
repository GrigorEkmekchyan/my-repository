package com.example.merchantx.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.merchantx.retrofit.bady.GenerateQRBody;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.manager.GenerateQRManager;
import com.example.merchantx.retrofit.manager.LoginManager;
import com.example.merchantx.retrofit.response.GenerateQRResponse;
import com.example.merchantx.retrofit.response.LoginResponse;


public class GenerateQRRepository implements GenerateQRManager.OnGenerateQRSearchListener {
    private MutableLiveData<GenerateQRResponse> liveData = new MutableLiveData();
    private MutableLiveData<String> failLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public void searchGenerateQRCall(GenerateQRBody generateQRBody){
        GenerateQRManager.searchGenerateQRManager(this, generateQRBody);
    }

    @Override
    public void onGenerateQRSearchSuccess(GenerateQRResponse generateQRResponse) {
        liveData.setValue(generateQRResponse);
    }

    @Override
    public void onGenerateQRSearchFail (String failMassage) {
       failLiveData.setValue(failMassage);
    }

    @Override
    public void onGenerateQRSearchError(String errorMassage) {

    }

    public MutableLiveData<GenerateQRResponse> getLiveData() {
        return liveData;
    }


    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
