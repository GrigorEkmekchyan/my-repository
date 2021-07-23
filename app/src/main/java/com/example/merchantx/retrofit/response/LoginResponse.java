package com.example.merchantx.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    @SerializedName("merchantUserId")
    @Expose
    private String merchantUserId;
    @SerializedName("merchants")
    @Expose
    private List<Merchant> merchants = null;
    @SerializedName("canReverse")
    @Expose
    private Boolean canReverse;
    @SerializedName("isGeneralUser")
    @Expose
    private Boolean isGeneralUser;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<Merchant> merchants) {
        this.merchants = merchants;
    }

    public Boolean getCanReverse() {
        return canReverse;
    }

    public void setCanReverse(Boolean canReverse) {
        this.canReverse = canReverse;
    }

    public Boolean getIsGeneralUser() {
        return isGeneralUser;
    }

    public void setIsGeneralUser(Boolean isGeneralUser) {
        this.isGeneralUser = isGeneralUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
