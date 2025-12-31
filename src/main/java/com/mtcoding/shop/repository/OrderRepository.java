package com.mtcoding.shop.repository;

import com.mtcoding.shop.DBConnection;
import com.mtcoding.shop.view.CartListView;
import com.mtcoding.shop.view.OrderListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    public int insert(int uId, int pId, int qty, int totalPrice) {

        // 1. DBMS와 연결된 소켓
        Connection conn = DBConnection.getConnection();

        // 2. 버퍼달기
        String sql = "insert into order_tb(u_id,p_id,qty,total_price) values(?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uId);
            pstmt.setInt(2, pId);
            pstmt.setInt(3, qty);
            pstmt.setInt(4, totalPrice);

            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<OrderListView> selectJoin(int uId) {
        Connection conn = DBConnection.getConnection();
        List<OrderListView> list = new ArrayList<>();


        String sql = "select o_id,u_name,p_name,qty,p_price,total_price from order_tb ot " +
                "left outer join user_tb ut " +
                "on ot.u_id = ut.u_id " +
                "left outer join product_tb pt " +
                "on ot.p_id = pt.p_id " +
                "where ut.u_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // rs를 자바오브젝트로 파싱
                int c1 = rs.getInt("o_id");
                String c2 = rs.getString("u_name");
                String c3 = rs.getString("p_name");
                int c4 = rs.getInt("qty");
                int c5 = rs.getInt("p_price");
                int c6 = rs.getInt("total_price");

                OrderListView orderListView = new OrderListView(c1, c2, c3, c4, c5, c6);
                list.add(orderListView);


            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
