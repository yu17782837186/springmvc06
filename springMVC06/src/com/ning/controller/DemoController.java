package com.ning.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("demo4")
    public String demo(Model model){
        System.out.println("执行demo");
//        int i = 5/0;
        model.addAttribute("model","每天都爱学习");
        return "/index.jsp";
    }

}
