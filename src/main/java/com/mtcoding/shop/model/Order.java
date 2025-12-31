package com.mtcoding.shop.model;

/**
 * order_tb
 */
public class Order {
    private Integer oId; // 숫자증가(PK)
    private Integer uId; // 주문한 유저 ID
    private Integer pId; // 주문한 상품 ID
    private Integer qty; // 주문한 상품 개수
    private Integer totalPrice; // 총 금액
}
