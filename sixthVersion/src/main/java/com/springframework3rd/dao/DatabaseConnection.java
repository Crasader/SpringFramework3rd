package com.springframework3rd.dao;

public class DatabaseConnection {
    public static DatabaseConnection getInstance() {
        return new DatabaseConnection();
    }

    public void releaseConnection() {

    }
}
