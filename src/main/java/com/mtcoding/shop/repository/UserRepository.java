package com.mtcoding.shop.repository;

import com.mtcoding.shop.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    // CREATE 회원가입 INSERT
    public int insert(String uName, String uPassword, String uEmail){

        Connection conn = DBConnection.getConnection();
        String sql = "insert into user_tb(u_name,u_password,u_email) values(?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,uName);
            pstmt.setString(2,uPassword);
            pstmt.setString(3,uEmail);

            int result = pstmt.executeUpdate();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
