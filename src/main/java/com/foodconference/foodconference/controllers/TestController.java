package com.foodconference.foodconference.controllers;

import io.jsonwebtoken.SignatureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class TestController {
    @GetMapping("/test")
    public  String test(){
        return "Hello";
    }
    @ExceptionHandler(SignatureException.class)
    public String handelException(SignatureException e) {
        return e.getMessage();
    }
}
