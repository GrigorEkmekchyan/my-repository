package com.example.merchantx.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.merchantx.repository.LoginRepository;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.response.LoginResponse;


    public class LoginViewModel extends ViewModel {
        private LoginRepository loginRepository;
        private MutableLiveData<LoginResponse> loginResponseMutableLiveData;
        private MutableLiveData<String> failLiveData;
        private MutableLiveData<String> errorLiveData;

        public LoginViewModel() {
            loginRepository= new LoginRepository();
            loginResponseMutableLiveData = loginRepository.getLiveData();
            failLiveData = loginRepository.getFailLiveData();
            errorLiveData = loginRepository.getErrorLiveData();
        }


        public MutableLiveData<LoginResponse> getLoginResponseMutableLiveData() {
            return loginResponseMutableLiveData;
        }

        public MutableLiveData<String> getFailLiveData() {
            return failLiveData;
        }

        public MutableLiveData<String> getErrorLiveData() {
            return errorLiveData;
        }



        public void searchLogin (LoginBody loginBody) {
            loginRepository.searchLoginCall(loginBody);
        }
    }


