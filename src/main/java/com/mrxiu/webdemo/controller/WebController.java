package com.mrxiu.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WebController {

    @GetMapping("/getSystemTime")
    public String getSystemTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    @GetMapping("/")
    public String home(ModelMap modelMap) {
        modelMap.put("sysTime", this.getSystemTime());
        return "hello";
    }

}
