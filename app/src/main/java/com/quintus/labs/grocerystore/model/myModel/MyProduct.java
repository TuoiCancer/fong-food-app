package com.quintus.labs.grocerystore.model.myModel;

import com.google.gson.annotations.SerializedName;

public class MyProduct {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("discount")
    String price;
    @SerializedName("description")
    String description;
    @SerializedName("category")
    MyCategory myCategory;
    @SerializedName("image")
    String imgProduct;
    @SerializedName("attribute")
    String attribute;
    @SerializedName("currency")
    String currency;
    @SerializedName("price")
    String discount;
    @SerializedName("homepage")
    String homepage;

    public MyProduct(int id, String name, String price,
                     String description, MyCategory myCategory,
                     String imgProduct, String attribute, String currency,
                     String discount, String homepage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.myCategory = myCategory;
        this.imgProduct = imgProduct;
        this.attribute = attribute;
        this.currency = currency;
        this.discount = discount;
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MyCategory getMyCategory() {
        return myCategory;
    }

    public void setMyCategory(MyCategory myCategory) {
        this.myCategory = myCategory;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
