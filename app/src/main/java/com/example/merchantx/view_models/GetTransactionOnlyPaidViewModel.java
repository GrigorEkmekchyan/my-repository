package com.example.merchantx.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.merchantx.repository.GetTransactionOnlyPaidRepository;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;

import java.util.List;


public class GetTransactionOnlyPaidViewModel extends ViewModel {
    private GetTransactionOnlyPaidRepository getTransactionOnlyPaidRepository;
    private MutableLiveData<List<GetTransactionsResponse>> getTransactionOnlyPaidResponseMutableLiveData;
    private MutableLiveData<String> failLiveData;
    private MutableLiveData<String> errorLiveData;

    public GetTransactionOnlyPaidViewModel() {
        getTransactionOnlyPaidRepository= new GetTransactionOnlyPaidRepository();
        getTransactionOnlyPaidResponseMutableLiveData = getTransactionOnlyPaidRepository.getLiveData();
        failLiveData = getTransactionOnlyPaidRepository.getFailLiveData();
        errorLiveData = getTransactionOnlyPaidRepository.getErrorLiveData();
    }


    public MutableLiveData<List<GetTransactionsResponse>> getGetTransactionOnlyPaidResponseMutableLiveData() {
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


