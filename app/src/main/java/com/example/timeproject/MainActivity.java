package com.example.timeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private DatabaseHelper DBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper = new DatabaseHelper(this);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i2+ "." +(i1+1)+ "." +i;
                Intent intent = new Intent(MainActivity.this, CalendarDayActivity.class);
                intent.putExtra("dateNumber",date);
                startActivity(intent);
            }
        });
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