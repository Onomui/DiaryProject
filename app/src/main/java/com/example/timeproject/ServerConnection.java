package com.example.timeproject;

public class ServerConnection {
    public String URL;
    public final String SERVER_ALL_USERS = "/api/users";
    public final String SERVER_REGISTER = "/api/register";
    public final String SERVER_LOGIN = "/api/login";

    public String getServerOnlyUser(String userEmail){
        return SERVER_ALL_USERS + userEmail;
    }

    public String deleteUser(String userEmail){
        return SERVER_ALL_USERS + userEmail;
    }
}
