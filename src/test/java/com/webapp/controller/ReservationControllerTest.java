package com.webapp.controller;

import org.junit.jupiter.api.DisplayName;
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

    // 장점: WebApplication 관련된 Bean들만 등록하기 때문에 통합 테스트보다 빠르다
    // 단점: 요청부터 응답까지 모든 테스트를 Mock 기반으로 테스트하기 때문에 실제 환경에서는 제대로 동작하지 않을 수 있다.
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/api/test"))
                .andExpect(status().isOk())     // HTTP Header의 Status를 검증 -> 200인지.
                .andExpect(content().string(hello));
    }

}
