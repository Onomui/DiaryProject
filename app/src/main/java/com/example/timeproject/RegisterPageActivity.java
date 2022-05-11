package com.example.timeproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterPageActivity extends AppCompatActivity {
    EditText emailEditText, nameEditText;
    EditText passwordEditText, confirmEditText;

    Button registerButton;

    ServerConnection serverConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        emailEditText = findViewById(R.id.emailRegisterEditText);
        nameEditText = findViewById(R.id.nameRegisterEditText);

        passwordEditText = findViewById(R.id.passwordRegisterEditText);
        confirmEditText = findViewById(R.id.confirmPasswordRegisterEditText);

        registerButton = findViewById(R.id.registerRegisterButton);
    }

    public void register(View view){
        String email = emailEditText.getText().toString();
        String name = nameEditText.getText().toString();

        String password = passwordEditText.getText().toString();
        String confirmed_password = confirmEditText.getText().toString();

        if (!password.equals(confirmed_password)){
            confirmEditText.setText(R.string.password_not_equals_confirmed);
            return;
        }



    }
}
