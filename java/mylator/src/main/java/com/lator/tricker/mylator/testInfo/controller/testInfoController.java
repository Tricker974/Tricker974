package com.lator.tricker.mylator.testInfo.controller;

import com.lator.tricker.mylator.testInfo.Pojo.infoPojo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class testInfoController {


    @RequestMapping("/table/basic")
    public String getInfo(Model model){
        List<infoPojo> list=new ArrayList<>();
        infoPojo bean=new infoPojo();
        bean.setFirstName("sb");
        bean.setInfoNo(1);
        bean.setLastName("sys");
        bean.setHandler("@DasB!");
        list.add(bean);
        infoPojo bean2=new infoPojo();
        /**
         *不能复用一个bean 为什么？
         */
        bean2.setFirstName("smart").setLastName("boy").setHandler("@Celever").setInfoNo(2);
        list.add(bean2);
        model.addAttribute("info",list);
        return "pages/table-basic-table";
    }
}
