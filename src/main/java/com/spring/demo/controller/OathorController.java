package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController

public class OathorController {
    private Object AuthorityUtils;

    @PostMapping("/oathor")
    public String shit(){

        return "true";
    }
}
