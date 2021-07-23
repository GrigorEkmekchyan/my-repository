package com.example.merchantx.fragments;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
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
import com.example.merchantx.base.Constants;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.view_models.LoginViewModel;

import static android.content.Context.MODE_PRIVATE;
import static com.example.merchantx.base.Constants.LOGIN;
import static com.example.merchantx.base.Constants.LOGIN_KEY;
import static com.example.merchantx.base.Constants.PASSWORD;
import static com.example.merchantx.base.Constants.PASSWORD_KEY;
import static com.example.merchantx.base.Constants.SHARED_PREFERENCES;
import static com.example.merchantx.base.Constants.USER_ID;
import static com.example.merchantx.base.Constants.USER_ID_KEY;


public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private ImageView ivLogoLogin;
    private Button btnLogin;
    private EditText etLogin;
    private EditText etPassword;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ivLogoLogin = view.findViewById(R.id.iv_logo_login);
        etLogin = view.findViewById(R.id.et_login);
        etPassword = view.findViewById(R.id.et_password);
        btnLogin = view.findViewById(R.id.btn_sign_in);
        btnLogin.setOnClickListener(this);


        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_sign_in:
                btnLogin.setEnabled(false);
                LOGIN = etLogin.getText().toString();
                PASSWORD  = etPassword.getText().toString();
                getLoader();
                LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
                LoginBody loginBody = new LoginBody();
                loginBody.setUsername(LOGIN);
                loginBody.setPassword(PASSWORD);
                loginViewModel.searchLogin(loginBody);
                loginViewModel.getLoginResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<LoginResponse>() {
                    @Override
                    public void onChanged(LoginResponse loginResponse) {
                        clearFragmentBackStack();
                        Constants.MERCHANT_ID = loginResponse.getMerchants().get(0).getId();
                        USER_ID = loginResponse.getMerchantUserId();
                        changeFragmentNotAddBackStack(R.id.fl_fragment_container, new MainFragment());
                        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
                        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
                        prefsEditor.putString(LOGIN_KEY, LOGIN);
                        prefsEditor.putString(PASSWORD_KEY, PASSWORD);
                        prefsEditor.putString(USER_ID_KEY, USER_ID);
                        prefsEditor.apply();
                        closeLoader();
                    }
                });

                loginViewModel.getFailLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        closeLoader(btnLogin);
                        Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                loginViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        closeLoader(btnLogin);
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }
}