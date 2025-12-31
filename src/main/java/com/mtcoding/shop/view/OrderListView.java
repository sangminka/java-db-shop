package com.mtcoding.shop.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderListView {
    private Integer oId; // 주문번호
    private String uName; // uId 대신 유저 이름 가져오기 (조인)
    private String pName; // pId 대신 상품 이름 가져오기 (조인)
    private Integer qty; // 주문한 상품 개수
    private Integer pPrice; // 상품 개별 가격
    private Integer totalPrice; // 주문한  상품 전체 금액
}
