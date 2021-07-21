package com.example.merchantx.retrofit.bady;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendSmsBody {
    @SerializedName("merchantId")
    @Expose
    private Integer merchantId;
    @SerializedName("transactionId")
    @Expose
    private Integer transactionId;
    @SerializedName("phone")
    @Expose
    private String phone;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
