package com.quintus.labs.grocerystore.model.myModel;

import com.google.gson.annotations.SerializedName;

public class MyCategory {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("img")
    String imgCate;

    public MyCategory(int id, String name, String imgCate) {
        this.id = id;
        this.name = name;
        this.imgCate = imgCate;
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

    public String getImgCate() {
        return imgCate;
    }

    public void setImgCate(String imgCate) {
        this.imgCate = imgCate;
    }
}
