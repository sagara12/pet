package com.example.pet.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/login 요청시 hello World를 출력")
    void test() throws Exception {
        //ID

        //Password


        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                                               .contentType(MediaType.APPLICATION_JSON)
                                               .content("{\"id\": \" 아이디 입니다.\", \"password\": \"패스워드 입니다.\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{}"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("/login 요청시 계정과 비밀번호 값은 필수다.")
    void test2() throws Exception {
        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"\",\"password\":\"패스워드 입니다.\"}")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("아이디를 입력해주세요"))
                .andDo(MockMvcResultHandlers.print());
    }
}