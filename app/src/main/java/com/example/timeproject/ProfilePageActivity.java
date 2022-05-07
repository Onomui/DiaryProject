package com.example.timeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfilePageActivity extends AppCompatActivity {

    public String userLogin;
    public String userPassword;
    EditText inputUserLogin;
    EditText inputUserPassword;
    Button btnLogin;
    DatabaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        DBHelper = new DatabaseHelper(this);

        ArrayList<String> userData = DBHelper.select_user(0);

        if (userData.get(1).equals("")){
            openLogin();
        }

    }

    public void openLogin(){
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
    }
}