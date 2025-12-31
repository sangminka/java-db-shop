package com.mtcoding.shop.repository;

import com.mtcoding.shop.DBConnection;
import com.mtcoding.shop.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public int update(int pId, int qty){

        Connection conn = DBConnection.getConnection();
        String sql = "update product_tb set p_stock=? where p_id=?";


        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,qty);
            pstmt.setInt(2,pId);

            int result = pstmt.executeUpdate();
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public List<Product> selectAll(){
        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();


        try {
            String sql = "select * from product_tb";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            List<Product> products = new ArrayList<>();

            // 조회해서 view로 응답밥기
            ResultSet rs = pstmt.executeQuery();

            // 행이 존재하면 프로젝션
            while (rs.next()){
                // rs를 자바오브젝트로 파싱
                int c1 = rs.getInt("p_id");
                String c2 = rs.getString("p_name");
                int c3 = rs.getInt("p_price");
                int c4 = rs.getInt("p_stock");
                Product product = new Product(c1,c2,c3,c4);
                products.add(product);

            }

            return products;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    // 상품 번호로 가격 찾기
    public Product selectOne(int pId){
        Connection conn = DBConnection.getConnection();

        String sql = "select * from product_tb where p_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,pId);

            // 조회해서 view로 응답
            ResultSet rs = pstmt.executeQuery();

            // 커서 한칸 내리기
            boolean isRow = rs.next();

            // 행이 존재하면 프로젝션
            if (isRow){
                int c1 = rs.getInt("p_id");
                String c2 = rs.getString("p_name");
                int c3 = rs.getInt("p_price");
                int c4 = rs.getInt("p_stock");
                Product product = new Product(c1,c2,c3,c4);

                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
