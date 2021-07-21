package com.example.merchantx.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.merchantx.repository.LoginRepository;
import com.example.merchantx.repository.SendSmsRepository;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.bady.SendSmsBody;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.retrofit.response.SendSmsResponse;


public class SendSmsViewModel extends ViewModel {
    private SendSmsRepository sendSmsRepository;
    private MutableLiveData<SendSmsResponse> sendSmsResponseMutableLiveData;
    private MutableLiveData<String> failLiveData;
    private MutableLiveData<String> errorLiveData;

    public SendSmsViewModel() {
        sendSmsRepository= new SendSmsRepository();
        sendSmsResponseMutableLiveData = sendSmsRepository.getLiveData();
        failLiveData = sendSmsRepository.getFailLiveData();
        errorLiveData = sendSmsRepository.getErrorLiveData();
    }


    public MutableLiveData<SendSmsResponse> getSendSmsResponseMutableLiveData() {
        return sendSmsResponseMutableLiveData;
    }

    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }


    public void searchSendSms (SendSmsBody sendSmsBody) {
        sendSmsRepository.searchSendSmsCall(sendSmsBody);
    }
}


