package com.quintus.labs.grocerystore.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResult {
    @SerializedName("products")
    List<Product> myProductList;
    @SerializedName("code")
    int code;
    @SerializedName("status")
    String status;


    public ProductResult(List<Product> myProductList, int code, String status) {
        this.myProductList = myProductList;
        this.code = code;
        this.status = status;
    }

    public List<Product> getProductList() {
        return myProductList;
    }

    public void setProductList(List<Product> myProductList) {
        this.myProductList = myProductList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
