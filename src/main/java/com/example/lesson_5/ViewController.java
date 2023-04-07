package com.example.lesson_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/view")
    public String view(){
        return "index.html";
    }
}