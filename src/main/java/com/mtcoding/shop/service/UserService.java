package com.mtcoding.shop.service;

import com.mtcoding.shop.repository.UserRepository;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void 회원가입(String name, String email){
        // 1. insert
    }
}
