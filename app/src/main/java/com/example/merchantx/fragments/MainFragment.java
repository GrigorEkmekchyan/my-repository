package com.example.merchantx.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;


import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.merchantx.R;
import com.example.merchantx.base.BaseFragment;
import com.example.merchantx.base.Constants;
import com.example.merchantx.retrofit.bady.GenerateQRBody;
import com.example.merchantx.retrofit.response.GenerateQRResponse;
import com.example.merchantx.view_models.GenerateQRViewModel;

public class MainFragment extends BaseFragment implements View.OnClickListener {

    private EditText etMoney;
    private EditText etComment;
    private CardView cvShare;
    private CardView cvQRGenerate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        etMoney = view.findViewById(R.id.et_money);
        etComment = view.findViewById(R.id.et_comment);
        cvShare = view.findViewById(R.id.cv_share);
        cvQRGenerate = view.findViewById(R.id.cv_generate_qr);
        cvShare.setOnClickListener(this);
        cvQRGenerate.setOnClickListener(this);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (etMoney.getText().toString().length() != 0) {

            switch (v.getId()) {
                case R.id.cv_share:
                    cvShare.setEnabled(false);
                    cvQRGenerate.setEnabled(false);
                    getLoader();
                    if (etMoney.getText().toString().length() > 0) {
                        GenerateQRViewModel model = new GenerateQRViewModel();
                        GenerateQRBody body = new GenerateQRBody();
                        body.setAmount(Integer.valueOf(etMoney.getText().toString()));
                        body.setComment(etComment.getText().toString());
                        body.setIsMulti(false);
                        body.setMerchantId(Constants.MERCHANT_ID);
                        model.searchGenerateQR(body);
                        model.getGenerateResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<GenerateQRResponse>() {
                            @Override
                            public void onChanged(GenerateQRResponse generateQRResponse) {
                                changeFragment(R.id.fl_fragment_container, new ShareFragment(generateQRResponse.getId(), generateQRResponse.getPayXUrl()));
                                closeLoader(cvShare);
                                cvQRGenerate.setEnabled(true);
                            }
                        });
                        model.getFailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                            @Override
                            public void onChanged(String s) {
                                closeLoader(cvShare);
                                cvQRGenerate.setEnabled(true);
                                Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                            }
                        });
                        model.getErrorLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                            @Override
                            public void onChanged(String s) {
                                closeLoader(cvShare);
                                cvQRGenerate.setEnabled(true);
                                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    break;

                case R.id.cv_generate_qr:

                    cvShare.setEnabled(false);
                    cvQRGenerate.setEnabled(false);                    getLoader();
                    if (etMoney.getText().toString().length() > 0) {
                        GenerateQRViewModel generateQRViewModel = new GenerateQRViewModel();
                        GenerateQRBody generateQRBody = new GenerateQRBody();
                        generateQRBody.setAmount(Integer.valueOf(etMoney.getText().toString()));
                        generateQRBody.setComment(etComment.getText().toString());
                        generateQRBody.setIsMulti(false);
                        generateQRBody.setMerchantId(Constants.MERCHANT_ID);
                        generateQRViewModel.searchGenerateQR(generateQRBody);
                        generateQRViewModel.getGenerateResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<GenerateQRResponse>() {
                            @Override
                            public void onChanged(GenerateQRResponse generateQRResponse) {
                                changeFragment(R.id.fl_fragment_container, new QRGenerateFragment(generateQRResponse.getCode()));
                                cvShare.setEnabled(true);
                                closeLoader(cvQRGenerate);
                            }
                        });
                        generateQRViewModel.getFailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                            @Override
                            public void onChanged(String s) {
                                Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                                cvShare.setEnabled(true);
                                closeLoader(cvQRGenerate);
                            }
                        });
                        generateQRViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                            @Override
                            public void onChanged(String s) {
                                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                                cvShare.setEnabled(true);
                                closeLoader(cvQRGenerate);
                            }
                        });
                    }
                    break;
            }
        } else {
            Toast.makeText(getContext(), "Pleas input amount", Toast.LENGTH_SHORT).show();
        }


    }


}
