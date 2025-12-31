package com.mtcoding.shop;

import com.mtcoding.shop.model.User;
import com.mtcoding.shop.repository.CartRepository;
import com.mtcoding.shop.repository.OrderRepository;
import com.mtcoding.shop.repository.ProductRepository;
import com.mtcoding.shop.repository.UserRepository;
import com.mtcoding.shop.service.ProductService;

public class ShopApp {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        CartRepository cartRepository = new CartRepository();
        UserRepository userRepository = new UserRepository();
        OrderRepository orderRepository = new OrderRepository();

        // 1. 상품등록
        ProductService ps = new ProductService(productRepository);
        ps.상품등록("바나나", 100, 5);
    }
}
