package com.quintus.labs.grocerystore.MyApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quintus.labs.grocerystore.model.User;
import com.quintus.labs.grocerystore.model.myModel.CategoryResult;
import com.quintus.labs.grocerystore.model.myModel.MyProduct;
import com.quintus.labs.grocerystore.model.myModel.ProductResult;
import com.quintus.labs.grocerystore.model.myModel.UserResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.75.244:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @POST("api/users/register")
    Call<UserResult> register(@Body User user);

    @POST("api/users/login")
    Call<UserResult> login(@Body User user);

    @GET("api/category")
    Call<CategoryResult> getAllCategory();

    @GET("api/products")
    Call<ProductResult> getAllProduct();

    @GET("api/products")
    Call<ProductResult> getAllProductByCategory(@Query("category") long id);


}
