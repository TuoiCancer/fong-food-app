package com.quintus.labs.grocerystore.model;


public class Product {
    String id;
    String category;
    String name;
    String description;
    String attribute;
    String currency;
    String price;
    String discount;
    String image;
    int imgUrl;
    String homepage;

    public Product() {
    }

    public Product(String id, String category, String name, String description, String attribute, String currency, String price, String discount, int imgUrl, String homepage) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.attribute = attribute;
        this.currency = currency;
        this.price = price;
        this.discount = discount;
        this.imgUrl = imgUrl;
        this.homepage = homepage;
    }

    public Product(String category, String name, String description, String attribute, String currency, String price, String discount, int imgUrl, String homepage) {

        this.category = category;
        this.name = name;
        this.description = description;
        this.attribute = attribute;
        this.currency = currency;
        this.price = price;
        this.discount = discount;
        this.imgUrl = imgUrl;
        this.homepage = homepage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
