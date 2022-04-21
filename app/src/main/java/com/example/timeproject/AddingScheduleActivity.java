package com.example.timeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddingScheduleActivity extends AppCompatActivity {

    EditText inputStartTime;
    EditText inputEndTime;
    EditText inputDescription;
    RadioGroup radioGroupOccurre;
    String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_schedule);

        Intent incomingDateIntent = getIntent();
        String thisDate = incomingDateIntent.getStringExtra("thisDate");
        date=thisDate;

        inputStartTime = (EditText) findViewById(R.id.editTextTimeStart);
        inputEndTime = (EditText) findViewById(R.id.editTextTimeEnd);
        inputDescription = (EditText) findViewById(R.id.editTextDescription);
        radioGroupOccurre = (RadioGroup) findViewById(R.id.radioGroupOccure);

    }

    public void AddToSchedule(View view) {

        String[] dayActivity = new String[4];

        switch (radioGroupOccurre.getCheckedRadioButtonId()) {
            case R.id.radioButtonEveryDay:
                dayActivity[0] = "Everyday";
                break;
            case R.id.radioButtonWorkDays:
                dayActivity[0] = "Workdays";
                break;
            case R.id.radioButtonThisDay:
                dayActivity[0]= date;
                break;
        }

        dayActivity[1] = inputStartTime.getText().toString();
        dayActivity[2] = inputEndTime.getText().toString();
        dayActivity[3] = inputDescription.getText().toString();

        Intent intent = new Intent(this, CalendarDayActivity.class);
        intent.putExtra("thisDateActivity",dayActivity);
        startActivity(intent);
    }
}
