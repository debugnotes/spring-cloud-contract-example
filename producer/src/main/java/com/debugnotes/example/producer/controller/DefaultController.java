package com.debugnotes.example.producer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class DefaultController {

    @RequestMapping(produces = "application/json")  // for contract testing, MUST USE "produces=", "consumes=" params,
    // "headers=" is insufficient for testing, but can still be used!!!
    @ResponseBody
    public String get() {
        return "{}";
    }
}
