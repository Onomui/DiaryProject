package com.example.timeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPageActivity extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;

    Button loginButton;
    Button registerButton;

    DatabaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        DBHelper = new DatabaseHelper(this);

        emailEditText = findViewById(R.id.emailLoginEditText);
        passwordEditText = findViewById(R.id.passwordLoginEditText);
        loginButton = findViewById(R.id.loginLoginButton);
        registerButton = findViewById(R.id.registerLoginButton);
    }

    public void login(View view){}

    public void register(View view){
        Intent intent = new Intent(this, RegisterPageActivity.class);
        startActivity(intent);
    }
}
