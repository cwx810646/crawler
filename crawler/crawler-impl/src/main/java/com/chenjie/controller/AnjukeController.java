package com.chenjie.controller;

import com.chenjie.impl.service.AnjuKeService;
import com.chenjie.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anjuke")
public class AnjukeController {
    @Autowired
    private AnjuKeService anjuKeService;

    @PostMapping("load")
    public Result<Object> load(){
        anjuKeService.capture();
        return Result.ok();
    }
}
