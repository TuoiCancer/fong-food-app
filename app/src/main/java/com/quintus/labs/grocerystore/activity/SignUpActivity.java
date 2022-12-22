package com.quintus.labs.grocerystore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quintus.labs.grocerystore.R;
import com.quintus.labs.grocerystore.MyApi.ApiService;
import com.quintus.labs.grocerystore.model.User;
import com.quintus.labs.grocerystore.model.myModel.UserResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity  {
    private static EditText email, phonenum , fullname, address, password;
    private static Button  signUp;
    private static TextView already_user;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        signUp = findViewById(R.id.signUpBtn);
        already_user = findViewById(R.id.already_user);
        email = findViewById(R.id.email);
        phonenum = findViewById(R.id.mobileNumber);
        fullname = findViewById(R.id.name);
        address=findViewById(R.id.address);
        password = findViewById(R.id.password);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailrg = email.getText().toString();
                String passwordrg = password.getText().toString();
                String phonenumrg = phonenum.getText().toString();
                String fullnamerg = fullname.getText().toString();
                String addressrg = address.getText().toString();
                if(TextUtils.isEmpty(emailrg)  || TextUtils.isEmpty(passwordrg) || TextUtils.isEmpty(phonenumrg) || TextUtils.isEmpty(fullnamerg) || TextUtils.isEmpty(addressrg) ){
                    Toast.makeText(SignUpActivity.this,"Các trường không được để trống !! " , Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = new User(fullnamerg , emailrg , phonenumrg, passwordrg,addressrg , "CLIENT");
                Log.d("User name", user.toString());

                ApiService.apiService.register(user).enqueue(new Callback<UserResult>() {
                    @Override
                    public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                        startActivity(new Intent(SignUpActivity.this , LoginActivity.class));
                    }

                    @Override
                    public void onFailure(Call<UserResult> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this,"Something went wrong!!!" , Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


        already_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this , LoginActivity.class));
            }
        });



    }
}
