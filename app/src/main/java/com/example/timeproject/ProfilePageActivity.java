package com.example.timeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfilePageActivity extends AppCompatActivity {

    public String userLogin;
    public String userPassword;
    EditText inputUserLogin;
    EditText inputUserPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        inputUserLogin = (EditText) findViewById(R.id.editTextLogin);
        inputUserPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
    }
    public void Login(View view) {
        userLogin=inputUserLogin.getText().toString();
        userPassword=inputUserPassword.getText().toString();
    }
}