package com.dziadkouskaya.mvp_training.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements iUser {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValid() {

        return
                //email is not empty
                !TextUtils.isEmpty(getEmail())
                        //email matches pattern (with @ and so on)
                        && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();

    }
}
