package com.ri.securenote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public String test() {
        return "Hello World";
    }
    @GetMapping("/contact")
    public String contact() {
        return "Hello People Contact us!";
    }
}
