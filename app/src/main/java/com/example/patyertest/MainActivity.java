package com.example.patyertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patyertest.Presenter.ILoginPresenter;
import com.example.patyertest.Presenter.LoginPresenter;
import com.example.patyertest.R;
import com.example.patyertest.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText editEmail;
    EditText editPassword;
    Button buttonLogin;
    Button buttonSingUpActivity;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSingUpActivity = findViewById(R.id.buttonSingUpActivity);

        loginPresenter = new LoginPresenter(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(editEmail.getText().toString(), editPassword.getText().toString());
            }
        });

        buttonSingUpActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



}