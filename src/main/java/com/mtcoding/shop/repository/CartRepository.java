package com.mtcoding.shop.repository;

import com.mtcoding.shop.DBConnection;
import com.mtcoding.shop.model.Cart;
import com.mtcoding.shop.view.CartListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartRepository {

    public CartListView selectJoin(int uId){
        return null;
    }

    public Cart selectOne(int uId){
        return null;
    }

    // 장바구니 담기
    // Create = insert
    public int 장바구니담기(int uId, int pId, int qty){
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();


        String sql = "insert into cart_tb(u_id, p_id,qty) values(?,?,?)";
        try {
            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uId);
            pstmt.setInt(2, pId);
            pstmt.setInt(3, qty);


            // 3. 쿼리전송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
