package com.iot.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexAction {
    @RequestMapping("/")
    public String login(){
        return "forward:/index.html";
    }
}
