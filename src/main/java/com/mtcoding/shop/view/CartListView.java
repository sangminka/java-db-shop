package com.mtcoding.shop.view;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * View 결과를 아래 클래스에 파싱하기
 */
@AllArgsConstructor
@Data
public class CartListView {
    private Integer cId; // 장바구니 번호
    private String uName; // uId 대신 유저 이름 가져오기 (조인)
    private String pName; // pId 대신 상품 이름 가져오기 (조인)
    private Integer qty; // 장바구니에 담은 상품 개수
}
