package com.quintus.labs.grocerystore.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quintus.labs.grocerystore.model.User;
import com.quintus.labs.grocerystore.model.UserResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.5:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @POST("api/users/register")
    Call<UserResult> register(@Body User user);

    @POST("api/users/login")
    Call<UserResult> login(@Body User user);

}
