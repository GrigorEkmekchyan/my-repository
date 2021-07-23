package com.example.merchantx.retrofit.response.get_paid_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Domain {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private Object title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }
}