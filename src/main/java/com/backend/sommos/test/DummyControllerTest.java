package com.backend.sommos.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @ResponseBody
    @RequestMapping("test")
    public String join(String username){
        System.out.println("username:"+username);

        return "회원가입 완료";
    }
}
