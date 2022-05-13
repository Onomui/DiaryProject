package com.example.timeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddingScheduleActivity extends AppCompatActivity {

    EditText inputStartTime, inputEndTime;
    EditText editTextName;
    EditText inputDescription;
    String date;
    DatabaseHelper DBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_schedule);

        Intent incomingDateIntent = getIntent();
        String thisDate = incomingDateIntent.getStringExtra("thisDate");
        date=thisDate;

        editTextName = findViewById(R.id.editTextName);
        inputStartTime = (EditText) findViewById(R.id.editTextTimeStart);
        inputEndTime = (EditText) findViewById(R.id.editTextTimeEnd);
        inputDescription = (EditText) findViewById(R.id.editTextDescription);
        DBHelper = new DatabaseHelper(this);

    }

    public void AddToSchedule(View view) {
        String eventName;
        String repeat;
        String eventStart;
        String eventEnd;
        String description;
        repeat="";

        eventStart = inputStartTime.getText().toString();
        eventEnd = inputEndTime.getText().toString();
        description = inputDescription.getText().toString();

        eventName = editTextName.getText().toString();

        DBHelper.insert_event(date, eventName, eventStart, eventEnd, description,repeat);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
