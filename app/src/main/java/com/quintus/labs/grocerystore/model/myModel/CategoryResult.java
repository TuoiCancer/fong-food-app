package com.quintus.labs.grocerystore.model.myModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResult {

    @SerializedName("data")
    List<MyCategory> categoryList;
    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;

    public CategoryResult(List<MyCategory> categoryList, int status, String message) {
        this.categoryList = categoryList;
        this.status = status;
        this.message = message;
    }

    public List<MyCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<MyCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
