package com.mtah.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    String index = "Welcome to Chops";

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(){
        return index;
    }

}
