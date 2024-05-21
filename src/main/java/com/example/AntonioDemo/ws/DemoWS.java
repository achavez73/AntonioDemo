package com.example.AntonioDemo.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoWS {

    @GetMapping("/helloWorld")
    public String hellowWorld() {
        return String.format("Hello World!");
    }
}
