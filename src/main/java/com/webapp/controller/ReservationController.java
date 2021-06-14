package com.webapp.controller;

import com.webapp.dto.ReservationDto;
import com.webapp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor    // final로 선언된 필드를 인자 값으로 하는 생성자를 대신 생성해줌
@RestController             // @ResponseBody 선언이 포함된 Controller
public class ReservationController {

    /**
     * Post vs Put
     * Post는 Create할 때, Put은 Update할 때.
     * Post는 멱등성을 가지지 않는 반면, Put은 멱등성을 갖는다
     * 멱등성이란 다수 요청에 대한 응답이 동일한 것.
     * Post는 여러 요청을 보내면 열이 추가됨.
     * Put은 여러 요청을 보내도 200과 같은 응답을 받음.
     **/

    /** @RequiredArgsConstructor 사용으로 제거 가능
    public ReservationController(ReservationService service) {
        this.service = service;
    }
     **/

    // 생성자로 의존성 주입
    // ApiController는 ReservationService 없인 아무것도 못함
    // 대신, RequiredArgsConstructor를 사용했기 때문에, 해당 의존성이 변경되도 해당 코드 수정할 필요 없음.
    private final ReservationService service;


    // get 방식의 메소드로 value 값처럼 넘겨주면 해당 메소드를 호춣하겠다. => RequestMaping으로 정의함
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)   // 반응은 이렇게 주겠다.
    public String getAPiTest() {
        return "hello";
    }


    // 예약 전체 조회
    @GetMapping("/reservation/all")
    public List<ReservationDto> getReservationList() {

        return service.getReservationList();
    }

    // 예약 상세 조회
    // @PathVariable => 해당 매개 변수가 URI 템플릿 변수에 바인딩되어야 함을 명시함
    @GetMapping("/reservation/{id}")
    public ReservationDto getReservation(@PathVariable("id") String id) {

        return service.getReservation(id);
    }

    // 예약 등록
    @PostMapping("/reservation/{id}")
    public void postReservation(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone
                                , @RequestParam("peopleCount") int peopleCount) {
        service.insertReservation(id, name, phone, peopleCount);
    }

    // 예약 수정
    @PutMapping("/reservation/{id}")
    public void putReservation(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone
                                , @RequestParam("peopleCount") int peopleCount) {
        service.updateReservation(id, name, phone, peopleCount);
    }

    // 예약 삭제
    @DeleteMapping("reservation/{id}")
    public void deleteReservation(@PathVariable("id") String id) {

        service.deleteReservation(id);
    }

}
