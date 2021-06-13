package com.webapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// @ResponseBody선언이 포함된 Controller
@RestController
public class ApiController {

    // get 방식의 메소드로 value 값처럼 넘겨주면 해당 메소드를 호춣하겠다. => RequestMapping으로 정의함
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    // 반응은 이렇게 주겠다.
    @ResponseStatus(value = HttpStatus.OK)
    //@GetMapping(value = "api/test")
    public String getAPiTest() {

        return "hello";
    }

    @PostMapping(value = "/api/test2")
    @ResponseStatus(value = HttpStatus.OK)
    public String getAPiTest2() {

        return "{\"result\":\"reserveApi2\"}";
    }

}
