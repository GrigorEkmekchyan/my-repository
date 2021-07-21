package com.example.merchantx.retrofit.bady;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerateQRBody {
    @SerializedName("merchantId")
    @Expose
    private Integer merchantId;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("isMulti")
    @Expose
    private Boolean isMulti;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getIsMulti() {
        return isMulti;
    }

    public void setIsMulti(Boolean isMulti) {
        this.isMulti = isMulti;
    }
}
