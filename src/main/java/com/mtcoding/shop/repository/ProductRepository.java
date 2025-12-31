package com.mtcoding.shop.repository;

import com.mtcoding.shop.DBConnection;
import com.mtcoding.shop.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductRepository {

    public int update(int pId, int qty){
        return -1;
    }

    public List<Product> selectAll(){
        return null;
    }

    public int insert(String pName, int pPrice, int pStock){
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();


        String sql = "insert into product_tb(p_name, p_price, p_stock) values(?,?,?)";
        try {
            // 2. 버퍼달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pName);
            pstmt.setInt(2, pPrice);
            pstmt.setInt(3, pStock);


            // 3. 쿼리전송
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
