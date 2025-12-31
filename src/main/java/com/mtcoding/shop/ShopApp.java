package com.mtcoding.shop;

import com.mtcoding.shop.model.Product;
import com.mtcoding.shop.model.User;
import com.mtcoding.shop.repository.CartRepository;
import com.mtcoding.shop.repository.OrderRepository;
import com.mtcoding.shop.repository.ProductRepository;
import com.mtcoding.shop.repository.UserRepository;
import com.mtcoding.shop.service.ProductService;
import com.mtcoding.shop.service.UserService;

import java.util.List;

public class ShopApp {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        CartRepository cartRepository = new CartRepository();
        UserRepository userRepository = new UserRepository();
        OrderRepository orderRepository = new OrderRepository();

        // 1. 상품등록
//        ProductService ps = new ProductService(productRepository);
//        ps.상품등록("딸기", 300, 7);
        // 2. 전체 상품 조회
//        List<Product> products = ps.상품목록보기();

//        for (Product s : products){
//            System.out.println(s);
//        }

        // 3. 회원가입
//        UserService us = new UserService(userRepository);
//        us.회원가입("coss","coss1234","coss@nate.com");


    }
}
