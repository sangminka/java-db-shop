package com.mtcoding.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * user_tb
 */
@AllArgsConstructor
@Data
public class User {
    private Integer uId; // 숫자증가(PK)
    private String uName; // 아이디
    private String uPassword; // 패스워드
    private String uEmail; // 이메일
}
