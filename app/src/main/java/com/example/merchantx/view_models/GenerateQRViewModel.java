package com.example.merchantx.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.merchantx.repository.GenerateQRRepository;
import com.example.merchantx.repository.LoginRepository;
import com.example.merchantx.retrofit.bady.GenerateQRBody;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.GenerateQRResponse;
import com.example.merchantx.retrofit.response.LoginResponse;


public class GenerateQRViewModel extends ViewModel {
    private GenerateQRRepository generateQRRepository;
    private MutableLiveData<GenerateQRResponse> generateQRResponseMutableLiveData;
    private MutableLiveData<String> failLiveData;
    private MutableLiveData<String> errorLiveData;

    public GenerateQRViewModel() {
        generateQRRepository= new GenerateQRRepository();
        generateQRResponseMutableLiveData = generateQRRepository.getLiveData();
        failLiveData = generateQRRepository.getFailLiveData();
        errorLiveData = generateQRRepository.getErrorLiveData();
    }


    public MutableLiveData<GenerateQRResponse> getGenerateResponseMutableLiveData() {
        return generateQRResponseMutableLiveData;
    }

    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }


    public void searchGenerateQR (GenerateQRBody generateQRBody) {
        generateQRRepository.searchGenerateQRCall(generateQRBody);
    }
}


