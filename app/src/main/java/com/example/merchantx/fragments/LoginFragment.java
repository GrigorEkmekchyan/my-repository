package com.example.merchantx.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.merchantx.R;
import com.example.merchantx.base.BaseFragment;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.view_models.LoginViewModel;


public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private ImageView ivLogoLogin;
    private Button btnLogin;
    private EditText etLogin;
    private EditText etPassword;
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ivLogoLogin = view.findViewById(R.id.iv_logo_login);
        etLogin = view.findViewById(R.id.et_login);
        etPassword = view.findViewById(R.id.et_password);
        progressBar = view.findViewById(R.id.pb_login_progress);
        btnLogin = view.findViewById(R.id.btn_sign_in);
        btnLogin.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_sign_in:
                LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
                LoginBody loginBody = new LoginBody();
                loginBody.setUsername(etLogin.getText().toString());
                loginBody.setPassword(etPassword.getText().toString());
                loginViewModel.searchLogin(loginBody);
                loginViewModel.getLoginResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<LoginResponse>() {
                    @Override
                    public void onChanged(LoginResponse loginResponse) {
                        changeFragment(R.id.fl_fragment_container, new MainFragment());
                    }
                });

                loginViewModel.getFailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                loginViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }
}