package com.webapp.controller;

import com.webapp.dto.ReservationDto;
import com.webapp.service.ReservationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@ExtendWith(SpringExtension.class)   // 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함.
@WebMvcTest(controllers = ReservationController.class)  // 여러 스프링 테스트 어노테이션 중, MVC에 집중할 수 있는 어노테이션임.
public class ReservationControllerTest {

    // 장점: WebApplication 관련된 Bean들만 등록하기 때문에 통합 테스트보다 빠르다
    // 단점: 요청부터 응답까지 모든 테스트를 Mock 기반으로 테스트하기 때문에 실제 환경에서는 제대로 동작하지 않을 수 있다.
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;


    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/api/test"))
                .andExpect(status().isOk())     // HTTP Header의 Status를 검증 -> 200인지.
                .andExpect(content().string(hello));
    }

    @Test
    @DisplayName("예약 전체 조회 테스트")
    public void Selectlist_Test() throws Exception {

        List<ReservationDto> reservationDtoList = new ArrayList<>();

        reservationDtoList.add(ReservationDto.builder().name("kmk").build());
        given(reservationService.getReservationList()).willReturn(reservationDtoList);

        mvc.perform(get("/reservation/all"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("kmk")));
    }

    @Test
    @DisplayName("예약 단건 조회 테스트")
    public void Byidselect_Test() throws Exception {

        ReservationDto reservationDto = ReservationDto.builder().phone("333-3333").build();
        given(reservationService.getReservation("3")).willReturn(reservationDto);

        mvc.perform(get("/reservation/3"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("333-3333")));
    }

}
