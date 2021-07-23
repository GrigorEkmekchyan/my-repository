package com.example.merchantx.fragments;

import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.merchantx.R;
import com.example.merchantx.adapters.PaidTransactionsAdapter;
import com.example.merchantx.base.BaseFragment;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;
import com.example.merchantx.view_models.GetTransactionOnlyPaidViewModel;

import java.util.List;

import static com.example.merchantx.base.Constants.MERCHANT_ID;


public class PaidHistoryFragment extends BaseFragment implements PaidTransactionsAdapter.OnMyItemClickListener {
    private GetTransactionOnlyPaidViewModel getTransactionOnlyPaidViewModel;
    private RecyclerView recyclerView;
    private PaidTransactionsAdapter paidTransactionsAdapter;
    private List<GetTransactionsResponse> getTransactionsResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_get_transaction_only_paid, container, false);
        recyclerView = view.findViewById(R.id.rv_done);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getTransactionOnlyPaidViewModel = ViewModelProviders.of(this).get(GetTransactionOnlyPaidViewModel.class);
        getTransactionOnlyPaidViewModel.searchGetTransactionOnlyPaid(MERCHANT_ID);
        getTransactionOnlyPaidViewModel.getGetTransactionOnlyPaidResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<GetTransactionsResponse>>() {
            @Override
            public void onChanged(List<GetTransactionsResponse> getTransactionsResponse) {
                paidTransactionsAdapter = new PaidTransactionsAdapter(getTransactionsResponse);
                recyclerView.setAdapter(paidTransactionsAdapter);
                paidTransactionsAdapter.setOnMyItemClickListener(PaidHistoryFragment.this);
                paidTransactionsAdapter.notifyDataSetChanged();
                setGetTransactionsResponse(getTransactionsResponse);
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