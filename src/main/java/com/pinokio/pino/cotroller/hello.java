package com.pinokio.pino.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }
}