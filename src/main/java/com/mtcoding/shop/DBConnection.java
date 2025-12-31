package com.mtcoding.shop;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * shop 데이터베이스에서 작업하시오!
 * create database shopdb;
 */
public class DBConnection {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/shopdb";
        String username = "root";
        String password = "bitc5600!";

        try {
            // new 클래스명();
            Class.forName("com.mysql.cj.jdbc.Driver");
            // conn =  프로토콜이 적용된 소켓
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}