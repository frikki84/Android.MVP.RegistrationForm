package com.dziadkouskaya.mvp_training;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dziadkouskaya.mvp_training.presenter.LoginPresenter;
import com.dziadkouskaya.mvp_training.presenter.iLoginPresenter;
import com.dziadkouskaya.mvp_training.view.iUserView;

public class MainActivity extends AppCompatActivity implements iUserView {

    EditText email;
    EditText password;
    Button btnLogIn;

    iLoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        email = findViewById(R.id.login_input_email);
        password = findViewById(R.id.login_input_password);
        btnLogIn = findViewById(R.id.btn_login);

        mLoginPresenter = new LoginPresenter(this);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.onLogin(email.getText().toString(), password.getText().toString());
                email.getText().clear();
                password.getText().clear();
            }
        });

    }

    @Override
    public void showResult(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
