package com.mtcoding.shop.repository;

import com.mtcoding.shop.DBConnection;
import com.mtcoding.shop.model.Cart;
import com.mtcoding.shop.view.CartListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {

    // 주문 이력 보기 selectJoin
    public List<CartListView> 장바구니보기(int uId){
        Connection conn = DBConnection.getConnection();
        List<CartListView> list = new ArrayList<>();

        String sql = "select c_id,u_name,p_name,qty from cart_tb ct " +
                "left outer join user_tb ut " +
                "on ct.u_id = ut.u_id " +
                "left outer join product_tb pt " +
                "on ct.p_id = pt.p_id " +
                "where ct.u_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,uId);

            // 조회해서 view로 응답밥기
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                // rs를 자바오브젝트로 파싱
                int c1 = rs.getInt("c_id");
                String c2 = rs.getString("u_name");
                String c3 = rs.getString("p_name");
                int c4 = rs.getInt("qty");
                CartListView cartListView = new CartListView(c1,c2,c3,c4);
                list.add(cartListView);

            }

            return list;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
