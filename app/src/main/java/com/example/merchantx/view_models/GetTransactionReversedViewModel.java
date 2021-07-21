package com.example.merchantx.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.merchantx.repository.GetTransactionOnlyPaidRepository;
import com.example.merchantx.repository.GetTransactionReversedRepository;
import com.example.merchantx.retrofit.response.GetTransactionOnlyPaidResponse;
import com.example.merchantx.retrofit.response.GetTransactionReversedResponse;


public class GetTransactionReversedViewModel extends ViewModel {
    private GetTransactionReversedRepository getTransactionReversedRepository;
    private MutableLiveData<GetTransactionReversedResponse> getTransactionReversedResponseMutableLiveData;
    private MutableLiveData<String> failLiveData;
    private MutableLiveData<String> errorLiveData;

    public GetTransactionReversedViewModel() {
        getTransactionReversedRepository= new GetTransactionReversedRepository();
        getTransactionReversedResponseMutableLiveData = getTransactionReversedRepository.getLiveData();
        failLiveData = getTransactionReversedRepository.getFailLiveData();
        errorLiveData = getTransactionReversedRepository.getErrorLiveData();
    }


    public MutableLiveData<GetTransactionReversedResponse> getGetTransactionReversedResponseMutableLiveData() {
        return getTransactionReversedResponseMutableLiveData;
    }

    public MutableLiveData<String> getFailLiveData() {
        return failLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }


    public void searchGetTransactionReversed (Integer id) {
        getTransactionReversedRepository.searchGetTransactionReversedCall(id);
    }
}


