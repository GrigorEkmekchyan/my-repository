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
import com.example.merchantx.adapters.ReverseTransactionsAdapter;
import com.example.merchantx.base.BaseFragment;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;
import com.example.merchantx.view_models.GetTransactionReversedViewModel;

import java.util.List;

import static com.example.merchantx.base.Constants.MERCHANT_ID;


public class ReversedHistoryFragment extends BaseFragment implements ReverseTransactionsAdapter.OnMyItemClickListener {
    private GetTransactionReversedViewModel getTransactionReversedViewModel;
    private RecyclerView recyclerView;
    private ReverseTransactionsAdapter reverseTransactionsAdapter;
    private List<GetTransactionsResponse> getTransactionsResponse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_reversed_history, container, false);
        recyclerView = view.findViewById(R.id.rv_done);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getTransactionReversedViewModel = ViewModelProviders.of(this).get(GetTransactionReversedViewModel.class);
        getTransactionReversedViewModel.searchGetTransactionReversed(MERCHANT_ID);
        getTransactionReversedViewModel.getGetTransactionReversedResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<GetTransactionsResponse>>() {
            @Override
            public void onChanged(List<GetTransactionsResponse> getTransactionsResponse) {
                setGetTransactionsResponse(getTransactionsResponse);
                reverseTransactionsAdapter = new ReverseTransactionsAdapter(getTransactionsResponse);
                recyclerView.setAdapter(reverseTransactionsAdapter);
                reverseTransactionsAdapter.setOnMyItemClickListener(ReversedHistoryFragment.this);
                reverseTransactionsAdapter.notifyDataSetChanged();
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