package com.mtcoding.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * cart_tb
 */
@AllArgsConstructor
@Data
public class Cart {
    private Integer cId;  // 숫자증가(PK)
    private Integer uId; // 장바구니에 담은 유저 ID
    private Integer pId; // 장바구니에 담은 상품 ID
    private Integer qty; // 장바구니에 담은 상품 개수
}
