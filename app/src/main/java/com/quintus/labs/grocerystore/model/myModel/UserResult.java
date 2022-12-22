package com.quintus.labs.grocerystore.model.myModel;

import com.google.gson.annotations.SerializedName;
import com.quintus.labs.grocerystore.model.User;

public class UserResult {
    @SerializedName("data")
    User user;
    @SerializedName("status")
    int status;
    @SerializedName("message")
    String message;

    public UserResult(User user, int status, String message) {
        this.user = user;
        this.status = status;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
