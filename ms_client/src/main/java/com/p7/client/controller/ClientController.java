package com.p7.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {

    @GetMapping("/hello")
    public String getHelloMsg () {
        return "Hello World";
    }
}
