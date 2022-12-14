package com.quintus.labs.grocerystore.fragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.quintus.labs.grocerystore.R;
import com.quintus.labs.grocerystore.activity.MainActivity;
import com.quintus.labs.grocerystore.model.User;
import com.quintus.labs.grocerystore.util.CustomToast;
import com.quintus.labs.grocerystore.util.Utils;
import com.quintus.labs.grocerystore.util.localstorage.LocalStorage;

import java.util.regex.Pattern;

public class SignUpFragment extends Fragment implements View.OnClickListener {
    private static View view;
    private static EditText fullName, mobileNumber,
            password;
    private static TextView login;
    private static Button signUpButton;
    private static CheckBox terms_conditions;
    User user;
    LocalStorage localStorage;
//    Gson gson = new Gson();
    View progress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_layout, container, false);
        initViews();
//        setListeners();
        return view;
    }

    // Initialize all views
    private void initViews() {
        fullName = view.findViewById(R.id.name);
        progress = view.findViewById(R.id.progress_bar);
//        emailId = view.findViewById(R.id.userEmailId);
        mobileNumber = view.findViewById(R.id.mobileNumber);

        password = view.findViewById(R.id.password);

        signUpButton = view.findViewById(R.id.signUpBtn);
        login = view.findViewById(R.id.already_user);
        signUpButton.setOnClickListener(SignUpFragment.this);

        // Setting text selector over textviews
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);

            login.setTextColor(csl);
            terms_conditions.setTextColor(csl);
        } catch (Exception e) {
        }
    }




    // Set Listeners
//    private void setListeners() {
//        signUpButton.setOnClickListener(this);
//        login.setOnClickListener(this);
//    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpBtn:
                // Call checkValidation method
//                checkValidation();
                startActivity(new Intent(getContext(), MainActivity.class));
//                Toast.makeText(SignUpFragment.this, "click button sign up", Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), "sign up click", Toast.LENGTH_LONG).show();
                break;



            case R.id.already_user:
                // Replace login fragment
//                new LoginRegisterActivity().replaceLoginFragment();
                break;
        }

    }

    // Check Validation Method
    private void checkValidation() {
        // Get all edittext texts
        String getFullName = fullName.getText().toString();
//        String getEmailId = emailId.getText().toString();
        String getMobileNumber = mobileNumber.getText().toString();
        String getPassword = password.getText().toString();
        // Pattern match for email id
        Pattern p = Pattern.compile(Utils.regEx);


        if (getFullName.length() == 0) {
            fullName.setError("Eneter Your Name");
            fullName.requestFocus();
        }/* else if (getEmailId.length() == 0) {
            emailId.setError("Eneter Your Email");
            emailId.requestFocus();
        } else if (!m.find()) {
            emailId.setError("Eneter Correct Email");
            emailId.requestFocus();
        }*/ else if (getMobileNumber.length() == 0) {
            mobileNumber.setError("Eneter Your Mobile Number");
            mobileNumber.requestFocus();
        } else if (getPassword.length() == 0) {
            password.setError("Eneter Password");
            password.requestFocus();
        } else if (getPassword.length() < 6) {
            password.setError("Eneter 6 digit Password");
            password.requestFocus();
        } else if (!terms_conditions.isChecked()) {
            new CustomToast().Show_Toast(getActivity(), view,
                    "Accept Term & Conditions");
        } else {
//            user = new User(getFullName, "", getMobileNumber, getPassword, firebaseToken);
//            registerUser(user);

        }

    }

//    private void registerUser(User userString) {
//        showProgressDialog();
//        Call<UserResult> call = RestClient.getRestService(getContext()).register(userString);
//        call.enqueue(new Callback<UserResult>() {
//            @Override
//            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
//                Log.d("Response :=>", response.body() + "");
//                if (response != null) {
//
//                    UserResult userResult = response.body();
//                    if (userResult != null && userResult.getCode() == 201) {
//                        String userString = gson.toJson(userResult.getUser());
//                        localStorage.createUserLoginSession(userString);
//                        Toast.makeText(getContext(), userResult.getStatus(), Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(getContext(), MainActivity.class));
//                        getActivity().finish();
//                    } else {
//                        new CustomToast().Show_Toast(getActivity(), view,
//                                "Server Error Please try after sometime");
//
//                    }
//
//                } else {
//                    new CustomToast().Show_Toast(getActivity(), view,
//                            "Please Enter Correct Data");
//                }
//
//                hideProgressDialog();
//
//            }
//
//            @Override
//            public void onFailure(Call<UserResult> call, Throwable t) {
//                Log.d("Error==> ", t.getMessage());
//                hideProgressDialog();
//            }
//        });
//    }

    private void hideProgressDialog() {
        progress.setVisibility(View.GONE);
    }

    private void showProgressDialog() {
        progress.setVisibility(View.VISIBLE);
    }


}
