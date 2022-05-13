package com.example.timeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

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
                if (!Objects.equals(dayArray.get(0),date)) {
                    continue;
                }
                for (String text:dayArray) {
                    if (Objects.equals(text,"")) {
                        continue;
                    }
                    if (Objects.equals(text,date)) {
                        continue;
                    }
                    TextView txtView = new TextView(this);
                    txtView.setText(text);
                    txtView.setTextAppearance(this, R.style.coolLookingText);
                    thisLL.addView(txtView,llParams);
                }
                TextView txtView = new TextView(this);
                txtView.setText("———————————————————————————");
                txtView.setTextAppearance(this, R.style.coolLookingText);
                thisLL.addView(txtView,llParams);
            }

            }


    }

    public void createSchedule(View view) {
        Intent intent = new Intent(this, AddingScheduleActivity.class);
        intent.putExtra("thisDate",date);
        startActivity(intent);
    }
    public void deleteSchedule(View view) {
        DBHelper.delete_event(date);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}