package com.zazpi.nozama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class NozamaApplication {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(NozamaApplication.class, args);
    }

}