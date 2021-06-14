package com.webapp.mapper;

import com.webapp.dto.ReservationDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReservationMapper {

    @Select("SELECT * FROM RESERVATION")
    List<ReservationDto> getReservationList();

    @Select("SELECT * FROM RESERVATION WHERE id=#{id}")
    ReservationDto getReservation(@Param("id") String id);

    @Insert("INSERT INTO RESERVATION VALUES(#{id}, #{name}, #{phone}, #{peopleCount})")
    int insertReservation(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("peopleCount") int peopleCount);

    @Update("UPDATE RESERVATION SET name=#{name}, phone=#{phone}, people_count=#{peopleCount} WHERE id=#{id}")
    int updateReservation(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("peopleCount") int peopleCount);

    @Delete("DELETE FROM RESERVATION WHERE id=#{id}")
    int deleteReservation(@Param("id") String id);

}
