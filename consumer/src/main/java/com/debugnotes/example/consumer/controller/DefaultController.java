package com.debugnotes.example.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DefaultController {

    public static final String defaultViewName = "index";

    public static final String resultAttributeName = "result";

    public static final String remoteEndpointUrl = "http://localhost:8081/profile";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView(defaultViewName);

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(remoteEndpointUrl, String.class);

        modelAndView.addObject(resultAttributeName, result);

        return modelAndView;
    }
}
