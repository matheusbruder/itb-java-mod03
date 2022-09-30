package br.com.mpbruder.springhelloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/nome/{nome}")
    public String getHello(@PathVariable String nome) {
        return "Hello, " + nome + "!";
    }


}
