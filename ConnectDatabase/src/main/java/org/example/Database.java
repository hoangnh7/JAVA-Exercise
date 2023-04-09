package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private Connection connection;
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javaturorial";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250"; // set your own limit
    private static Database instance = new Database();

    public static Database getInstance() {
        return instance;
    }
    public Connection getConnection(){
        if (connection== null){
            try {
                //thêm parameter
                Properties properties = new Properties();
                properties.setProperty("user",USERNAME);
                properties.setProperty("password",PASSWORD);
                properties.setProperty("MaxPooledStatements",MAX_POOL);

                //Check whether DriverManager exist
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL,properties);
            }catch (ClassNotFoundException| SQLException exception){
                System.out.println("Cannot connect to DB,error: " + exception.toString());
            }
        }
    return connection;
    }
    public void disconnect(){
        if(connection != null){
            try{
                connection.close();
                connection = null;
            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }
    }
}
