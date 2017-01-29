package com.springframework3rd.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller(value="sayHelloController")
@RequestMapping("/saySomething")
public class HelloWorldController {
    /*@Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> modelData = new HashMap<>();
        modelData.put("msg", "Hello world!!");
        return new ModelAndView("helloworld", modelData);
    }*/

    @RequestMapping("/sayhello")
    public ModelAndView sayHello() {
        Map<String, String> modelData = new HashMap<>();
        modelData.put("msg", "Hello world!!");
        return new ModelAndView("helloworld", modelData);
    }
}
