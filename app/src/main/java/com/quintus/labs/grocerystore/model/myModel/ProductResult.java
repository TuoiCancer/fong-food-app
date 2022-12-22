package com.quintus.labs.grocerystore.model.myModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResult {
    @SerializedName("data")
    List<MyProduct> productList;
    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;

    public ProductResult(List<MyProduct> productList, int status, String message) {
        this.productList = productList;
        this.status = status;
        this.message = message;
    }

    public List<MyProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<MyProduct> productList) {
        this.productList = productList;
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
