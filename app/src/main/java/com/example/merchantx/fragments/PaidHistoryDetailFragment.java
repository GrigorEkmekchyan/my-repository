package com.example.merchantx.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.merchantx.R;
import com.example.merchantx.base.BaseFragment;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;

import java.util.List;

public class PaidHistoryDetailFragment extends BaseFragment {

private GetTransactionsResponse  getTransactionsResponses;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_paid_history_detail, container, false);
        return view;
    }

    public PaidHistoryDetailFragment(GetTransactionsResponse getTransactionsResponses) {
        this.getTransactionsResponses = getTransactionsResponses;
    }
}