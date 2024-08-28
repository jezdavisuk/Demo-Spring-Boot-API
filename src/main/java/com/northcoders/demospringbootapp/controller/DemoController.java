package com.northcoders.demospringbootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/test")
    private String testMapping() {
        return "<html><body><h1>Test!</h1></body></html>";
    }

    @GetMapping("/hello")
    private String getHello() {
        return "<html><img src=\"https://media.tenor.com/WuOwfnsLcfYAAAAC/star-wars-obi-wan-kenobi.gif\" /></html>";
    }
}
