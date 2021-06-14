package com.webapp.service;

import com.webapp.dto.ReservationDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReservationService {

    List<ReservationDto> getReservationList();

    ReservationDto getReservation(@Param("id") String id);

    int insertReservation(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("peopleCount") int peopleCount);

    int updateReservation(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("peopleCount") int peopleCount);

    int deleteReservation(@Param("id") String id);

}
