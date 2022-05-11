package com.example.timeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CalendarDayActivity extends AppCompatActivity {


    public ArrayList<String[]> userActivities = new ArrayList<>();
    private TextView dateTextView;
    private String date;
    private LinearLayout thisLL;
    private String username = "Name";

    DatabaseHelper DBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_day);
        dateTextView = (TextView) findViewById(R.id.date);
        DBHelper = new DatabaseHelper(this);
        Intent incomingDateIntent = getIntent();
        String date = incomingDateIntent.getStringExtra("dateNumber");
        this.date=date;
        dateTextView.setText(date);
        thisLL = (LinearLayout) findViewById(R.id.thisLinearLaysout);
        Intent incomingIntent = getIntent();
        String[] incomingNewActivity = incomingIntent.getStringArrayExtra("thisDateActivity");

        ArrayList<ArrayList<String>> userEvents = DBHelper.selectAllEvents();
        if (!userEvents.isEmpty()) {
            LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            for (ArrayList<String> dayArray:userEvents) {
                for (String text:dayArray) {
                    TextView txtView = new TextView(this);
                    txtView.setText(text);
                    thisLL.addView(txtView,llParams);
                }
            }

            }


    }

    public void createSchedule(View view) {
        Intent intent = new Intent(this, AddingScheduleActivity.class);
        intent.putExtra("thisDate",date);
        startActivity(intent);
    }
}