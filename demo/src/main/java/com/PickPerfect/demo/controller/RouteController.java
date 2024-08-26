package com.PickPerfect.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// paths not directly handled by SpringBoot are forwarded to index.html using this controller

@Controller
public class RouteController {

    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        // Forward to the React app
        return "forward:/index.html";
    }
}
