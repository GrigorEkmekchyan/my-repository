package com.example.merchantx.fragments;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merchantx.R;
import com.example.merchantx.adapters.UnpaidTransactionsAdapter;
import com.example.merchantx.base.BaseFragment;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;
import com.example.merchantx.view_models.GetTransactionNotPaidViewModel;

import java.util.List;

import static com.example.merchantx.base.Constants.MERCHANT_ID;

public class UnpaidHistoryFragment extends BaseFragment implements UnpaidTransactionsAdapter.OnMyItemClickListener {
    private GetTransactionNotPaidViewModel getTransactionNotPaidViewModel;
    private RecyclerView recyclerView;
    private UnpaidTransactionsAdapter unpaidTransactionsAdapter;
    private List<GetTransactionsResponse> getTransactionsResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_unpaid_history, container, false);
        recyclerView = view.findViewById(R.id.rv_done);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getTransactionNotPaidViewModel = ViewModelProviders.of(this).get(GetTransactionNotPaidViewModel.class);
        getTransactionNotPaidViewModel.searchGetTransactionNotPaid(MERCHANT_ID);
        getTransactionNotPaidViewModel.getGetTransactionNotPaidResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<GetTransactionsResponse>>() {
            @Override
            public void onChanged(List<GetTransactionsResponse> getTransactionsResponse) {
                setGetTransactionsResponse(getTransactionsResponse);
                unpaidTransactionsAdapter = new UnpaidTransactionsAdapter(getTransactionsResponse);
                recyclerView.setAdapter(unpaidTransactionsAdapter);
                unpaidTransactionsAdapter.setOnMyItemClickListener(UnpaidHistoryFragment.this);
                unpaidTransactionsAdapter.notifyDataSetChanged();
            }
        });

        return view;

    }

    public void setGetTransactionsResponse(List<GetTransactionsResponse> getTransactionsResponse) {
        this.getTransactionsResponse = getTransactionsResponse;
    }

    @Override
    public void onItemClicked(int position) {
        changeFragment(R.id.fl_fragment_container, new PaidHistoryDetailFragment(getTransactionsResponse.get(position)));
    }
}