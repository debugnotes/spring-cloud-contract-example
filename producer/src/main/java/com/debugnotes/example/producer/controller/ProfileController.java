package com.debugnotes.example.producer.controller;

import com.debugnotes.example.producer.model.ProfileData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @RequestMapping(produces = "application/json")  // for contract testing, MUST USE "produces=", "consumes=" params,
    // "headers=" is insufficient for testing, but can still be used!!!
    @ResponseBody
    public ProfileData getDefaultProfile() {
        return new ProfileData(101, new String[0]);
    }
}
