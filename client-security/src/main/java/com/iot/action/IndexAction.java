package com.iot.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {
    @RequestMapping("/")
    public String login(){
        return "forward:/index.html";
    }
}
