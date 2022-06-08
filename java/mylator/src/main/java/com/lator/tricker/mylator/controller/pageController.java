package com.lator.tricker.mylator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping("/welcome")
    public String welCome(){
        return "welcome";
    }

    @RequestMapping("/index2")
    public String index2(){
        return "pages/index2";
    }

    @RequestMapping("/login")
    public String login(){ return "login";}

   /* @RequestMapping("/table/basic")
    public String table_basic(){ return "pages/table-basic-table";}*/
}
