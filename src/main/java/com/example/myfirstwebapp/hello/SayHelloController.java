package com.example.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {

    @GetMapping("say-hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("say-hello-jsp")
    public String sayHelloJSP() {
        return "sayHello";
    }

}
