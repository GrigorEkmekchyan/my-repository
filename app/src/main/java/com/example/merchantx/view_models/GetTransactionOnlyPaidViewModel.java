package com.example.merchantx.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.merchantx.repository.GetTransactionOnlyPaidRepository;
import com.example.merchantx.repository.LoginRepository;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.GetTransactionOnlyPaidResponse;
import com.example.merchantx.retrofit.response.LoginResponse;


public class GetTransactionOnlyPaidViewModel extends ViewModel {
    private GetTransactionOnlyPaidRepository getTransactionOnlyPaidRepository;
    private MutableLiveData<GetTransactionOnlyPaidResponse> getTransactionOnlyPaidResponseMutableLiveData;
    private MutableLiveData<String> failLiveData;
    private MutableLiveData<String> errorLiveData;

    public GetTransactionOnlyPaidViewModel() {
        getTransactionOnlyPaidRepository= new GetTransactionOnlyPaidRepository();
        getTransactionOnlyPaidResponseMutableLiveData = getTransactionOnlyPaidRepository.getLiveData();
        failLiveData = getTransactionOnlyPaidRepository.getFailLiveData();
        errorLiveData = getTransactionOnlyPaidRepository.getErrorLiveData();
    }


    public MutableLiveData<GetTransactionOnlyPaidResponse> getGetTransactionOnlyPaidResponseMutableLiveData() {
        return getTransactionOnlyPaidResponseMutableLiveData;
    }

    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }


    public void searchGetTransactionOnlyPaid (Integer id) {
        getTransactionOnlyPaidRepository.searchGetTransactionOnlyPaidCall(id);
    }
}


