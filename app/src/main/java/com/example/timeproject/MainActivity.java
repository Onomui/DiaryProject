package com.example.timeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void openProfile(View view) {
        Intent intent = new Intent(this, ProfilePageActivity.class);
        startActivity(intent);
    }
    public void openGuide(View view) {
        Intent intent = new Intent(this, GuidePageActivity.class);
        startActivity(intent);
    }
    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsPageActivity.class);
        startActivity(intent);
    }
}