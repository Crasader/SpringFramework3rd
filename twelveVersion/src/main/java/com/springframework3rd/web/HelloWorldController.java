package com.springframework3rd.web;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> modelData = new HashMap<>();
        modelData.put("msg", "Hello world!!");
        return new ModelAndView("helloworld", modelData);
    }
}
