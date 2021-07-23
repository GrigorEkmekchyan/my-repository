package com.example.merchantx.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.merchantx.R;
import com.example.merchantx.base.BaseFragment;
import com.example.merchantx.retrofit.bady.SendSmsBody;
import com.example.merchantx.retrofit.response.SendSmsResponse;
import com.example.merchantx.view_models.SendSmsViewModel;

import static com.example.merchantx.base.Constants.MERCHANT_ID;


public class ShareFragment extends BaseFragment implements View.OnClickListener {
    private int transferId;
    private String link;
    private EditText etPhone;
    private Button btnSandSMS;
    private Button btnShare;

    public ShareFragment(int transferId, String link) {
        this.transferId = transferId;
        this.link = link;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share, container, false);
        btnSandSMS = view.findViewById(R.id.btn_sand_sms);
        btnSandSMS.setOnClickListener(this);
        btnShare = view.findViewById(R.id.btn_share);
        btnShare.setOnClickListener(this);
        etPhone = view.findViewById(R.id.et_phone);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        btnShare.setEnabled(true);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_sand_sms:
                btnSandSMS.setEnabled(false);
                getLoader();
                SendSmsViewModel sendSmsViewModel = ViewModelProviders.of(this).get(SendSmsViewModel.class);
                SendSmsBody sendSmsBody = new SendSmsBody();
                sendSmsBody.setMerchantId(MERCHANT_ID);
                sendSmsBody.setTransactionId(transferId);
                sendSmsBody.setPhone(etPhone.getText().toString());
                sendSmsViewModel.searchSendSms(sendSmsBody);
                sendSmsViewModel.getSendSmsResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<SendSmsResponse>() {
                    @Override
                    public void onChanged(SendSmsResponse sendSmsResponse) {
                        closeLoader(btnSandSMS);
                        Toast.makeText(getContext(), "Sanded", Toast.LENGTH_SHORT).show();
                    }
                });
                sendSmsViewModel.getFailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        closeLoader(btnSandSMS);
                        Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                sendSmsViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        closeLoader(btnSandSMS);
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.btn_share:
                btnShare.setEnabled(false);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, link);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                break;
        }

    }


}