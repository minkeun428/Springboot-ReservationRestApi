package com.webapp.service;

import com.webapp.dto.ReservationDto;
import com.webapp.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    private ReservationMapper reservationMapper;
    public ReservationServiceImpl(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    // 예약 전체 조회
    @Override
    public List<ReservationDto> getReservationList() {
        return reservationMapper.getReservationList();

    }

    // 예약 단건 조회
    @Override
    public ReservationDto getReservation(String id) {
        return reservationMapper.getReservation(id);

    }

    // 예약 등록
    @Override
    public int insertReservation(String id, String name, String phone, int peopleCount) {
        return reservationMapper.insertReservation(id, name, phone, peopleCount);
    }

    // 예약 수정
    @Override
    public int updateReservation(String id, String name, String phone, int peopleCount) {
        return reservationMapper.updateReservation(id, name, phone, peopleCount);

    }

    // 예약 삭제
    @Override
    public int deleteReservation(String id) {
        return reservationMapper.deleteReservation(id);

    }

}
