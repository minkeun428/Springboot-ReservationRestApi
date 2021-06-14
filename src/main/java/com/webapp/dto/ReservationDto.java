package com.webapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {
    private String id;                      // 예약 ID
    private String name;                    // 예약자 이름
    private String phone;                   // 예약자 번호
    private int peopleCount;                // 예약 인원

}
