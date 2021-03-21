package com.example.accessingdatamysql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GiveBackController {

    @GetMapping("/greeting")
    public String greeting() {
        System.out.println("GET triggered");
        return "asd";
    }
}
