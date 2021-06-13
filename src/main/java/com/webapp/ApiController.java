package com.webapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    // get 방식의 메소드로 value 값처럼 넘겨주면 해당 메소드를 호춣하겠다. => RequestMapping으로 정의함
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    // 반응은 이렇게 주겠다.
    @ResponseStatus(value = HttpStatus.OK)
    public String getAPiTest() {

        return "{\"result\":\"reserveApi\"}";
    }

    @RequestMapping(value = "/api/test2", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String getAPiTest2() {

        return "{\"result\":\"reserveApi2\"}";
    }

}
