package com.example.computermarket.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBRepository {
    private static final String URL ="";
    private static final String USER = "";
    private static final String PASS = "";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("");
            connection = DriverManager.getConnection(URL,USER,PASS);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
