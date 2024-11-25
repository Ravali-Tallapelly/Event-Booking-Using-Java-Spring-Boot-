package com.mycompany.eventbooking.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/test")
    public String testPage() {
        return "test";  // test.html should be in templates folder
    }
}
