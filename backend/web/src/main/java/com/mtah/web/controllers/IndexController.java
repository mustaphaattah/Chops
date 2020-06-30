package com.mtah.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public ResponseEntity<?> index(){
        return new ResponseEntity<>("index", HttpStatus.OK);
    }

}
