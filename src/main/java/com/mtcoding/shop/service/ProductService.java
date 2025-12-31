package com.mtcoding.shop.service;

import com.mtcoding.shop.model.Product;
import com.mtcoding.shop.repository.ProductRepository;

import java.util.List;

public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 트랜잭션
    public void 상품등록(String pName, int pPrice, int pStock){
        // 1. insert
        productRepository.insert(pName, pPrice, pStock);
    }

    public List<Product> 상품목록보기(){
        // 1. 전체조회 (order by pId desc)
        return null;
    }
}
