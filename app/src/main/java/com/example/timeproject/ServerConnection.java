package com.example.timeproject;

import java.util.ArrayList;

public class ServerConnection {
    public String URL;
    public final String SERVER_ALL_USERS = "/api/users";
    public final String SERVER_REGISTER = "/api/register";
    public final String SERVER_LOGIN = "/api/login";

    public boolean login(String email, String password){
        return false;
    }

    public boolean register(String email, String name, String password){
        return false;
    }

    public ArrayList<String> getUser(String email){
        ArrayList<String> userInfo = new ArrayList<>();
        return userInfo;
    }

    public ArrayList<ArrayList<String>> getAllUsers(){
        ArrayList<ArrayList<String>> all_users = new ArrayList<>();
        return all_users;
    }

}
