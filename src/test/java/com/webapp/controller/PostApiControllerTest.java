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


@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationController.class)
public class PostApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;



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
