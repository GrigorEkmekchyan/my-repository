package com.example.merchantx.fragments;

import android.os.Bundle;

import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.merchantx.R;
import com.example.merchantx.base.BaseFragment;
import com.example.merchantx.retrofit.bady.GenerateQRBody;
import com.example.merchantx.retrofit.bady.SendSmsBody;
import com.example.merchantx.retrofit.response.GenerateQRResponse;
import com.example.merchantx.retrofit.response.SendSmsResponse;
import com.example.merchantx.view_models.GenerateQRViewModel;
import com.example.merchantx.view_models.SendSmsViewModel;

public class MainFragment extends BaseFragment implements View.OnClickListener {

    private EditText etMoney;
    private EditText etComment;
    private Button btnPay;
    private Button btnQRGenerate;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        etMoney = view.findViewById(R.id.et_money);
        etComment = view.findViewById(R.id.et_comment);
        btnPay = view.findViewById(R.id.btn_pay);
        btnQRGenerate = view.findViewById(R.id.btn_qr_generate);
        btnPay.setOnClickListener(this);
        btnQRGenerate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_pay:
                SendSmsViewModel sendSmsViewModel = new SendSmsViewModel();
                SendSmsBody sendSmsBody = new SendSmsBody();
                sendSmsBody.setMerchantId();
                sendSmsBody.setTransactionId();
                sendSmsBody.setPhone();
                sendSmsViewModel.searchSendSms(sendSmsBody);
                sendSmsViewModel.getSendSmsResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<SendSmsResponse>() {
                    @Override
                    public void onChanged(SendSmsResponse sendSmsResponse) {
                        changeFragment(R.id.fl_fragment_container, new ShareFragment());
                    }
                });
                sendSmsViewModel.getFailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                sendSmsViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.btn_qr_generate:
                GenerateQRViewModel generateQRViewModel = new GenerateQRViewModel();
                GenerateQRBody generateQRBody = new GenerateQRBody();
                generateQRBody.setAmount(Integer.valueOf(etMoney.getText().toString()));
                generateQRBody.setComment(etComment.getText().toString());
                generateQRBody.setIsMulti();
                generateQRBody.setMerchantId();
                generateQRViewModel.searchGenerateQR(generateQRBody);
                generateQRViewModel.getGenerateResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<GenerateQRResponse>() {
                    @Override
                    public void onChanged(GenerateQRResponse generateQRResponse) {
                        changeFragment(R.id.fl_fragment_container, new QRGenerateFragment());
                    }
                });
                generateQRViewModel.getFailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                generateQRViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }

    }
}
