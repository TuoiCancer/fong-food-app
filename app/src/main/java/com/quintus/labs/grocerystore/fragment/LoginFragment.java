package com.quintus.labs.grocerystore.fragment;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.quintus.labs.grocerystore.R;

public class LoginFragment extends Fragment implements  OnClickListener {
    private static View view;

    private static EditText mobile, password;
    private static Button loginButton;
    private static TextView forgotPassword, signUp;
    private static CheckBox show_hide_password;
    private static LinearLayout loginLayout;
    private static Animation shakeAnimation;
    private static FragmentManager fragmentManager;
    Gson gson = new Gson();
    View progress;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_layout, container, false);
        initViews();
//        setListeners();
        return view;
    }

    // Initiate Views
    private void initViews() {
//        fragmentManager = getActivity().getSupportFragmentManager();
        progress = view.findViewById(R.id.progress_bar);
        mobile = view.findViewById(R.id.login_email);
        password = view.findViewById(R.id.login_password);
        loginButton = view.findViewById(R.id.loginBtn);
        forgotPassword = view.findViewById(R.id.forgot_password);
        signUp = view.findViewById(R.id.createAccount);
        show_hide_password = view
                .findViewById(R.id.show_hide_password);
        loginLayout = view.findViewById(R.id.login_layout);

        loginButton.setOnClickListener(LoginFragment.this);
        signUp.setOnClickListener(LoginFragment.this);

        Gson gson = new Gson();
//        user = gson.fromJson(userString, User.class);
//        Log.d("User", userString);
        // Load ShakeAnimation
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.shake);


        // Setting text selector over textviews
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);

            forgotPassword.setTextColor(csl);
            show_hide_password.setTextColor(csl);
            signUp.setTextColor(csl);
        } catch (Exception e) {
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createAccount:
//                checkValidation();
                startActivity(new Intent(getContext(), SignUpFragment.class));
                break;

            case R.id.already_user:
//                new LoginRegisterActivity().replaceLoginFragment();
                break;
        }
    }
}
