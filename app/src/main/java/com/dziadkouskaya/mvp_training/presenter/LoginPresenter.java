package com.dziadkouskaya.mvp_training.presenter;

import com.dziadkouskaya.mvp_training.model.User;
import com.dziadkouskaya.mvp_training.view.iUserView;

public class LoginPresenter implements iLoginPresenter {
    public static final String MSG_LOGIN_SUCCESS = "Login is success";
    public static final String MSG_LOGIN_NOT_SUCCESS = "You don't log in";


    iUserView userView;

    public LoginPresenter(iUserView userView) {
        this.userView = userView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);

        boolean isLoginSuccess = user.isValid();

        if (isLoginSuccess) {
            userView.showResult(MSG_LOGIN_SUCCESS);
        } else {
            userView.showResult(MSG_LOGIN_NOT_SUCCESS);
        }



    }
}
