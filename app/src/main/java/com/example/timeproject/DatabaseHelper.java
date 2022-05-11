package com.example.timeproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper {

    private static final String DATABASE_NAME = "userInformation.sqlite"; // Название БД
    private static final int DATABASE_VERSION = 3; // При изменение структуры БД увеличить + 1

    private static final String TABLE_USER_INFO = "userInfo";

    private static final String USER_INFO_COLUMN_ID = "id"; // Id пользователя
    private static final String USER_INFO_COLUMN_EMAIL = "email"; // Email пользователя (Логин)
    private static final String USER_INFO_COLUMN_NAME = "name"; // Имя пользователя
    private static final String USER_INFO_COLUMN_PASSWORD = "password"; // Пароль пользователя

    private static final int USER_INFO_NUM_COLUMN_ID = 0;
    private static final int USER_INFO_NUM_COLUMN_EMAIL = 1;
    private static final int USER_INFO_NUM_COLUMN_NAME = 2;
    private static final int USER_INFO_NUM_COLUMN_PASSWORD = 3;


    private static final String TABLE_EVENTS = "events";

    private static final String EVENTS_COLUMN_DATE = "date"; // Дата события ("11.05.2022")
    private static final String EVENTS_COLUMN_NAME = "name"; // Название события ("Английский")
    private static final String EVENTS_COLUMN_REPEAT = "repeat"; // Повтор события ("Каждый день")
    private static final String EVENTS_COLUMN_EVENT_START = "event_start"; // Время начала ("16:40")
    private static final String EVENTS_COLUMN_EVENT_END = "event_end"; // Время конца ("18:10")
    private static final String EVENTS_COLUMN_DESCRIPTION = "description"; // Описание ивента ("...")

    private static final int EVENTS_NUM_COLUMN_DATE = 0;
    private static final int EVENTS_NUM_COLUMN_NAME = 1;
    private static final int EVENTS_NUM_COLUMN_REPEAT = 2;
    private static final int EVENTS_NUM_COLUMN_EVENT_START = 3;
    private static final int EVENTS_NUM_COLUMN_EVENT_END = 4;
    private static final int EVENTS_NUM_COLUMN_DESCRIPTION = 5;

    private final SQLiteDatabase mDataBase;

    public DatabaseHelper(Context context) {
        OpenHelper mOpenHelper = new OpenHelper(context);
        mDataBase = mOpenHelper.getWritableDatabase();
    }

    // Внесение нового события (метод INSERT)
    public long insert_event(String date, String name, String repeat, String event_start, String event_end, String description) {
        ContentValues cv = new ContentValues();
        cv.put(EVENTS_COLUMN_DATE, date);
        cv.put(EVENTS_COLUMN_NAME, name);
        cv.put(EVENTS_COLUMN_REPEAT, repeat);
        cv.put(EVENTS_COLUMN_EVENT_START, event_start);
        cv.put(EVENTS_COLUMN_EVENT_END, event_end);
        cv.put(EVENTS_COLUMN_DESCRIPTION, description);
        return mDataBase.insert(TABLE_EVENTS, null, cv);
    }

    // Изменение данных пользователя (метод UPDATE)
    public int update_user(int id, String email, String name, String password) {
        ContentValues cv = new ContentValues();
        cv.put(USER_INFO_COLUMN_EMAIL, email);
        cv.put(USER_INFO_COLUMN_NAME, name);
        cv.put(USER_INFO_COLUMN_PASSWORD, password);
        return mDataBase.update(TABLE_USER_INFO, cv, USER_INFO_COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    // Удаление данных о пользователе (метод UPDATE)
    public void delete_user(int id) {
        ContentValues cv = new ContentValues();
        cv.put(USER_INFO_COLUMN_EMAIL, "");
        cv.put(USER_INFO_COLUMN_NAME, "");
        cv.put(USER_INFO_COLUMN_PASSWORD, "");

        mDataBase.update(TABLE_USER_INFO, cv, USER_INFO_COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    // Удаление события (метод DELETE)
    public void delete_event(String date, String name) {
        mDataBase.delete(TABLE_EVENTS,
                EVENTS_COLUMN_DATE + " = ?," + EVENTS_COLUMN_NAME + " = ?",
                new String[]{date, name});
    }

    // Получение данных пользователя (метод SELECT)
    public ArrayList<String> select_user(int id) {
        ArrayList<String> arrs = new ArrayList<String>();

        Cursor mCursor = mDataBase.query(TABLE_USER_INFO, null, USER_INFO_COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (mCursor.moveToFirst()) {

            String email = mCursor.getString(USER_INFO_NUM_COLUMN_EMAIL);
            String name = mCursor.getString(USER_INFO_NUM_COLUMN_NAME);
            String password = mCursor.getString(USER_INFO_NUM_COLUMN_PASSWORD);

            arrs.add(String.valueOf(id));
            arrs.add(email);
            arrs.add(name);
            arrs.add(password);
        }

        return arrs;
    }

    // Получение данных о событии (метод SELECT)
    public ArrayList<String> select_event(String date, String event_name) {
        ArrayList<String> arrs = new ArrayList<String>();

        Cursor mCursor = mDataBase.query(TABLE_EVENTS,
                null,
                EVENTS_COLUMN_DATE + " = ?, " + EVENTS_COLUMN_NAME + " = ?",
                new String[]{date, event_name}, null, null, null);

        if (mCursor.moveToFirst()) {

            String name = mCursor.getString(EVENTS_NUM_COLUMN_NAME);
            String repeat = mCursor.getString(EVENTS_NUM_COLUMN_REPEAT);
            String event_start = mCursor.getString(EVENTS_NUM_COLUMN_EVENT_START);
            String event_end = mCursor.getString(EVENTS_NUM_COLUMN_EVENT_END);
            String description = mCursor.getString(EVENTS_NUM_COLUMN_DESCRIPTION);

            arrs.add(date);
            arrs.add(name);
            arrs.add(repeat);
            arrs.add(event_start);
            arrs.add(event_end);
            arrs.add(description);
        }
        
        return arrs;
    }

    // Получение данных о всех событиях (метод SELECT (SELECT ALL))
    public ArrayList<ArrayList<String>> selectAll_events() {
        ArrayList<ArrayList<String>> arrs = new ArrayList<ArrayList<String>>();
        try {
            Cursor mCursor = mDataBase.query(TABLE_EVENTS, null, null, null, null, null, null);
        }
        catch (Exception e){
            return arrs;
        }
        Cursor mCursor = mDataBase.query(TABLE_EVENTS, null, null, null, null, null, null);

        if (!mCursor.moveToFirst()){
            return arrs;
        }
        if (!mCursor.isAfterLast()) {
            do {
                ArrayList<String> tmp = new ArrayList<String>() {
                };

                String date = mCursor.getString(EVENTS_NUM_COLUMN_DATE);
                String name = mCursor.getString(EVENTS_NUM_COLUMN_NAME);
                String repeat = mCursor.getString(EVENTS_NUM_COLUMN_REPEAT);
                String event_start = mCursor.getString(EVENTS_NUM_COLUMN_EVENT_START);
                String event_end = mCursor.getString(EVENTS_NUM_COLUMN_EVENT_END);
                String description = mCursor.getString(EVENTS_NUM_COLUMN_DESCRIPTION);

                tmp.add(date);
                tmp.add(name);
                tmp.add(repeat);
                tmp.add(event_start);
                tmp.add(event_end);
                tmp.add(description);

                arrs.add(tmp);
            } while (mCursor.moveToNext());
        }
        return arrs;
    }

    // Класс подключения к базе данных
    // Пересоздаёт таблицы при увеличение константы DATABASE_VERSION
    private class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query_user = "CREATE TABLE " + TABLE_USER_INFO + " (" +
                    USER_INFO_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    USER_INFO_COLUMN_EMAIL + " STRING, " +
                    USER_INFO_COLUMN_NAME + " STRING, " +
                    USER_INFO_COLUMN_PASSWORD + " STRING);";
            db.execSQL(query_user);

            String query_events = "CREATE TABLE " + TABLE_EVENTS + " (" +
                    EVENTS_COLUMN_DATE + " STRING, " +
                    EVENTS_COLUMN_NAME + " STRING, " +
                    EVENTS_COLUMN_REPEAT + " STRING, " +
                    EVENTS_COLUMN_EVENT_START + " STRING," +
                    EVENTS_COLUMN_EVENT_END + " STRING," +
                    EVENTS_COLUMN_DESCRIPTION + " STRING);";

            db.execSQL(query_events);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_INFO);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
            onCreate(db);
        }
    }
}