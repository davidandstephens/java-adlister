package com.codeup.adlister;

public class Config {
    private String user = "root";
    private String password = "codeup12";
    private String url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}