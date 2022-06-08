package com.lator.tricker.mylator.sys.controller;

import com.lator.tricker.mylator.sys.pojo.UserPojo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @RequestMapping("/sys/login")
    public String Login(UserPojo bean, Model model, HttpSession session)throws Exception{
        if(bean !=null){
            if(bean.getUserName()==null|| bean.getUserName()==""||(!bean.getUserName().equals("admin"))){
                model.addAttribute("msg","账户名不正确！");
                return "/login.html";
            }else if(bean.getPassWord()==null||bean.getPassWord()==""||(!bean.getPassWord().equals("123456"))){
                model.addAttribute("msg","密码不正确！");
                return "/login.html";
            }
        }
        //登录成功后储存session
        session.setAttribute("loginUser",bean.getUserName());
        return "redirect:/index.html";
    }
}
