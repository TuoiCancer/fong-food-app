package com.quintus.labs.grocerystore.model;

public class listCate {
    String id;
    String categoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public listCate(String id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

}
