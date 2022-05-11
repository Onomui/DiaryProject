package com.example.timeproject;

import android.app.DownloadManager;
import android.util.Log;
import android.view.textclassifier.TextLinks;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.HttpURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServerConnection {
    public String serverAdress;
    public final String SERVER_ALL_USERS = "/api/users"; // /api/users/<string:user_email>
    public final String SERVER_REGISTER = "/api/register";
    public final String SERVER_LOGIN = "/api/login";
    public final String SERVER_DELETE_USER = "/api/delete_user";
    OkHttpClient Client = new OkHttpClient();

    // Смена адреса
    public void changeURL(String newUrl){
        serverAdress = newUrl;
    }

    // Логин в аккаунт (метод POST)
    public boolean login(String email, String password){
        return false;
    }

    // Регистрация аккаунта (метод POST)
    public boolean register(String email, String name, String password){
        return false;
    }

    // Удаление аккаунта (метод POST)
    public boolean deleteUser(String email, String password){
        return false;
    }

    // Получение информации об аккаунте (метод GET)
    public ArrayList<String> getUser(String email){
        ArrayList<String> userInfo = new ArrayList<>();
        
        return userInfo;
    }

    // Получение информации о всех аккаунтах (метод GET)
    public ArrayList<ArrayList<String>> getAllUsers(){
        ArrayList<ArrayList<String>> all_users = new ArrayList<>();

        return all_users;
    }

}
