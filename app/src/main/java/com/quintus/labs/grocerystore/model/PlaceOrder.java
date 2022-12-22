package com.quintus.labs.grocerystore.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaceOrder {
    @SerializedName("token")
    String token;
    @SerializedName("fname")
    String fname;
    @SerializedName("lname")
    String lname;
    @SerializedName("mobile")
    String mobile;
    @SerializedName("area")
    String area;
    @SerializedName("address")
    String address;

    @SerializedName("orderitems")
    List<OrderItem> orderitems;

    public PlaceOrder(String token, String fname, String lname, String mobile, String area, String address, List<OrderItem> orderitems) {
        this.token = token;
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
        this.area = area;
        this.address = address;
        this.orderitems = orderitems;
    }

    public PlaceOrder() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

}
