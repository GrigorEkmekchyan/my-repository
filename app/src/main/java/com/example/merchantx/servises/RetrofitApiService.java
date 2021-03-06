package com.example.merchantx.servises;


import com.example.merchantx.retrofit.bady.GenerateQRBody;
import com.example.merchantx.retrofit.bady.LoginBody;
import com.example.merchantx.retrofit.bady.SendSmsBody;
import com.example.merchantx.retrofit.response.GenerateQRResponse;
import com.example.merchantx.retrofit.response.GetTransactionNotPaidResponse;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;
import com.example.merchantx.retrofit.response.GetTransactionReversedResponse;
import com.example.merchantx.retrofit.response.LoginResponse;
import com.example.merchantx.retrofit.response.SendSmsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitApiService {


    @POST("api/Login/Login")
    Call<LoginResponse> loginCall(
            @Body() LoginBody loginBody);

    @POST("api/Payment/SendSms")
    Call<SendSmsResponse> sendSmsCall(
            @Body() SendSmsBody sendSmsBody);

    @GET("api/Payment/GetTransactionsOnlyPaid")
    Call<List<GetTransactionsResponse>> getTransactionOnlyPaidCall(
            @Query("id") Integer id);

    @GET("api/Payment/GetTransactionsNotPaid")
    Call<List<GetTransactionsResponse>> getTransactionNotPaidCall(
            @Query("id") Integer id);

    @GET("api/Payment/GetTransactionsReversed")
    Call<List<GetTransactionsResponse>> getTransactionReversedCall(
            @Query("id") Integer id);

    @POST("api/Qr/GenerateQR")
    Call<GenerateQRResponse> generateQRCall(
            @Body() GenerateQRBody generateQRBody);
}
