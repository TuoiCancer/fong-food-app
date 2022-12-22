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

import com.google.gson.Gson;
import com.quintus.labs.grocerystore.R;
import com.quintus.labs.grocerystore.MyApi.ApiService;
import com.quintus.labs.grocerystore.model.User;
import com.quintus.labs.grocerystore.model.myModel.UserResult;
import com.quintus.labs.grocerystore.util.localstorage.LocalStorage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity  extends AppCompatActivity {

    private static EditText email, password;
    private static Button loginButton;
    private static TextView  signUp;
    private static User userInfo;
    Gson gson;
    LocalStorage localStorage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.loginBtn);
        signUp = findViewById(R.id.createAccount);

        Gson gson = new Gson();
        localStorage = new LocalStorage(getApplicationContext());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emaillg = email.getText().toString();
                String passwordlq = password.getText().toString();
                if(TextUtils.isEmpty(emaillg)) {
                    Toast.makeText(LoginActivity.this,"Email khong duoc de trong!" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passwordlq)){
                    Toast.makeText(LoginActivity.this,"Password khong duoc de trong!" , Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = new User(emaillg ,passwordlq );
                ApiService.apiService.login(user).enqueue(new Callback<UserResult>() {
                    @Override
                    public void onResponse(Call<UserResult> call, Response<UserResult> response) {

                        Log.e("R", "onResponse: "+ response.body());
                        if(response != null){
                            UserResult userResult = response.body();
                            if(userResult.getStatus() == 200){
                                userInfo = userResult.getUser();
                                String userStr = gson.toJson(userInfo);
                                localStorage.createUserLoginSession(userStr);
                            } else if (userResult.getStatus() == 404) {
                                Toast.makeText(LoginActivity.this,userResult.getMessage().toString() , Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                        startActivity(new Intent(LoginActivity.this , MainActivity.class));
                    }

                    @Override
                    public void onFailure(Call<UserResult> call, Throwable t) {
                        Log.d("response login API: ", t.toString());
                        Toast.makeText(LoginActivity.this,t.toString() , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this , SignUpActivity.class));
            }
        });


    }

}
