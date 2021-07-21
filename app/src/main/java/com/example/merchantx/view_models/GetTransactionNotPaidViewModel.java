package com.example.merchantx.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.merchantx.repository.GetTransactionNotPaidRepository;
import com.example.merchantx.repository.GetTransactionOnlyPaidRepository;
import com.example.merchantx.retrofit.response.GetTransactionNotPaidResponse;
import com.example.merchantx.retrofit.response.GetTransactionOnlyPaidResponse;


public class GetTransactionNotPaidViewModel extends ViewModel {
    private GetTransactionNotPaidRepository getTransactionNotPaidRepository;
    private MutableLiveData<GetTransactionNotPaidResponse> getTransactionNotPaidResponseMutableLiveData;
    private MutableLiveData<String> failLiveData;
    private MutableLiveData<String> errorLiveData;

    public GetTransactionNotPaidViewModel() {
        getTransactionNotPaidRepository= new GetTransactionNotPaidRepository();
        getTransactionNotPaidResponseMutableLiveData = getTransactionNotPaidRepository.getLiveData();
        failLiveData = getTransactionNotPaidRepository.getFailLiveData();
        errorLiveData = getTransactionNotPaidRepository.getErrorLiveData();
    }


    public MutableLiveData<GetTransactionNotPaidResponse> getGetTransactionNotPaidResponseMutableLiveData() {
        return getTransactionNotPaidResponseMutableLiveData;
    }

    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }


    public void searchGetTransactionNotPaid (Integer id) {
        getTransactionNotPaidRepository.searchGetTransactionNotPaidCall(id);
    }
}


