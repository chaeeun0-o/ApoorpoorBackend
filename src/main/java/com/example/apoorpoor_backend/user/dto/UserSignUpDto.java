package com.example.apoorpoor_backend.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSignUpDto {

    private String memberId;
    private String password;
    private String nickname;
    private int age;
    private String city;
}
