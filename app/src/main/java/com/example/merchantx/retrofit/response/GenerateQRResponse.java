package com.example.merchantx.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerateQRResponse {
    @SerializedName("payXUrl")
    @Expose
    private String payXUrl;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;

    public String getPayXUrl() {
        return payXUrl;
    }

    public void setPayXUrl(String payXUrl) {
        this.payXUrl = payXUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
