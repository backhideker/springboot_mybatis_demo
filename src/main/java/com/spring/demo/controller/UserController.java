package com.spring.demo.controller;


import com.spring.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jie.a.xie on 8/31/2020.
 */
@Controller

public class UserController {

    @Autowired
    public IUserService userService;
    @RequestMapping(value = "/userlogin")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session
    ){
        if(!StringUtils.isEmpty(username)){
            session.setAttribute("loginUser",username);
            System.out.println(session.getAttributeNames());
            return "redirect:/page1.html";
        }
         return "scsacsac";
    }

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/test1/{username}")
    public ResponseEntity test1(@PathVariable("username") String userName){
        return ResponseEntity.ok(userService.getUserPhone(userName));
    }

    @GetMapping("/test2/{username}")
    public ResponseEntity test2(@PathVariable("username") String userName){
        return ResponseEntity.ok(userService.saveUser(userName));
    }

    @GetMapping("/test3/{phone}")
    public ResponseEntity test3(@PathVariable("phone") String phone){
        return ResponseEntity.ok(userService.getUser(phone));
    }
}
