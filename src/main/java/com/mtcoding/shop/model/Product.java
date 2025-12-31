package com.mtcoding.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * product_tb
 */
@AllArgsConstructor
@Data
public class Product {
    private Integer pId; // 숫자증가(PK)
    private String pName; // 상품명
    private Integer pPrice; // 상품가격
    private Integer pStock; // 상품재고
}
