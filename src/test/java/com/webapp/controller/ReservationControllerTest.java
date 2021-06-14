package com.webapp.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)   // 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함.
@WebMvcTest(controllers = ReservationController.class)  // 여러 스프링 테스트 어노테이션 중, MVC에 집중할 수 있는 어노테이션임.
public class ReservationControllerTest {

    @Autowired   // 스프링이 관리하는 빈 주입 받기
    private MockMvc mvc;    // 웹 API 테스트용, 테스트 시작점.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/api/test"))
                .andExpect(status().isOk())     // HTTP Header의 Status를 검증 -> 200인지.
                .andExpect(content().string(hello));
    }

}
