package com.bankappmvc.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/")
    public ModelAndView printWelcome() {
        Map<String, String> modelData = new HashMap<>();
        modelData.put("msg", "welcome");
        return new ModelAndView("helloworld", modelData);
    }

    @RequestMapping("/sayhello")
    public ModelAndView sayHello() {
        Map<String, String> modelData = new HashMap<>();
        modelData.put("msg", "Hello world!!");
        return new ModelAndView("helloworld", modelData);
    }
}
