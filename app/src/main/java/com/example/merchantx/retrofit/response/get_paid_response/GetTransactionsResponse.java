package com.example.merchantx.retrofit.response.get_paid_response;

import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTransactionsResponse {
    @SerializedName("transactionId")
    @Expose
    private Integer transactionId;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("transactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("transactionType")
    @Expose
    private Integer transactionType;
    @SerializedName("merchantId")
    @Expose
    private Integer merchantId;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("authCode")
    @Expose
    private String authCode;
    @SerializedName("bankTid")
    @Expose
    private String bankTid;
    @SerializedName("bankFee")
    @Expose
    private Double bankFee;
    @SerializedName("payxFee")
    @Expose
    private Integer payxFee;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("transactionOutOrLocal")
    @Expose
    private Integer transactionOutOrLocal;
    @SerializedName("card")
    @Expose
    private Card card;
    @SerializedName("arcaOrderId")
    @Expose
    private String arcaOrderId;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("appName")
    @Expose
    private Object appName;
    @SerializedName("domain")
    @Expose
    private Domain domain;
    @SerializedName("transactionStatus")
    @Expose
    private Integer transactionStatus;
    @SerializedName("isMulti")
    @Expose
    private Boolean isMulti;
    @SerializedName("qr")
    @Expose
    private String qr;
    @SerializedName("merchantName")
    @Expose
    private String merchantName;
    @SerializedName("merchantUsername")
    @Expose
    private String merchantUsername;
    @SerializedName("merchantUserId")
    @Expose
    private String merchantUserId;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBankTid() {
        return bankTid;
    }

    public void setBankTid(String bankTid) {
        this.bankTid = bankTid;
    }

    public Double getBankFee() {
        return bankFee;
    }

    public void setBankFee(Double bankFee) {
        this.bankFee = bankFee;
    }

    public Integer getPayxFee() {
        return payxFee;
    }

    public void setPayxFee(Integer payxFee) {
        this.payxFee = payxFee;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getTransactionOutOrLocal() {
        return transactionOutOrLocal;
    }

    public void setTransactionOutOrLocal(Integer transactionOutOrLocal) {
        this.transactionOutOrLocal = transactionOutOrLocal;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getArcaOrderId() {
        return arcaOrderId;
    }

    public void setArcaOrderId(String arcaOrderId) {
        this.arcaOrderId = arcaOrderId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object getAppName() {
        return appName;
    }

    public void setAppName(Object appName) {
        this.appName = appName;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Boolean getIsMulti() {
        return isMulti;
    }

    public void setIsMulti(Boolean isMulti) {
        this.isMulti = isMulti;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantUsername() {
        return merchantUsername;
    }

    public void setMerchantUsername(String merchantUsername) {
        this.merchantUsername = merchantUsername;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

}