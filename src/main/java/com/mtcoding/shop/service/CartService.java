package com.mtcoding.shop.service;

import com.mtcoding.shop.repository.CartRepository;
import com.mtcoding.shop.view.CartListView;

import java.util.List;


public class CartService {

    CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void 장바구니담기(int uId, int pId, int qty){
        // 1. cart insert
        cartRepository.장바구니담기(uId,pId,qty);
    }

    public List<CartListView> 장바구니보기(int uId){
        // 1. cart selectJoin(uId)

//        cartRepository.장바구니보기(uId);
        return cartRepository.장바구니보기(uId);
    }
}
