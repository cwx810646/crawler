package com.chenjie.api.controller;

import com.chenjie.api.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
public class HelloController {

    @GetMapping("hello")
    public Result<String> hello(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            log.error("{}", e);
        }
        String greet = "hello world!";
        return Result.ok(greet);
    }
}
