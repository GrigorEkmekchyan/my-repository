package com.example.merchantx.retrofit.response.get_paid_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {
    @SerializedName("maskedPan")
    @Expose
    private String maskedPan;
    @SerializedName("expiryDate")
    @Expose
    private Integer expiryDate;
    @SerializedName("cardHolderName")
    @Expose
    private String cardHolderName;
    @SerializedName("bindingId")
    @Expose
    private Object bindingId;
    @SerializedName("color")
    @Expose
    private Object color;
    @SerializedName("name")
    @Expose
    private Object name;

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public Integer getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Object getBindingId() {
        return bindingId;
    }

    public void setBindingId(Object bindingId) {
        this.bindingId = bindingId;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

}