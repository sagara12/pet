package com.example.pet.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountCreate {

    @NotBlank(message = "아이디를 입력해주세요")
    public String id;

    @NotBlank(message = "패스워드를 입력해주세요")
    public String password;

}
