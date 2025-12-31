package com.mtcoding.shop.service;

import com.mtcoding.shop.repository.OrderRepository;
import com.mtcoding.shop.repository.ProductRepository;
import com.mtcoding.shop.view.OrderListView;

import java.util.List;

/**
 * 서비스는 트랜잭션 관리 책임
 */
public class OrderService {

    ProductRepository productRepository;
    OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public void 주문하기(int uId, int pId, int qty){
        // 1. product selectOne(pId) -> 가격

        // 2. order insert

        // 3. product update(pId, qty)
    }

    // 유저별 주문 이력 보기
    public List<OrderListView> 주문이력보기(int uId){
        // 1. selectJoin();
        return null;
    }
}
