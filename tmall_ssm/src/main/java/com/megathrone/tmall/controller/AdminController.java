package com.megathrone.tmall.controller;


import com.megathrone.tmall.pojo.User;
import com.megathrone.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequestMapping("")
public class AdminController {


    @Autowired
    UserService userService;

    @RequestMapping("admin")
    public String admin(Model model){
        return "admin/adminLogin";
    }

    @RequestMapping("admin_login")
    public String admin_login(@RequestParam("name") String name,
                              @RequestParam("password") String password,
                              Model model){
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);

        if(null == user){
            String msg = "Wrong username or password";
            model.addAttribute("msg",msg);
            return "admin/adminLogin";
        }

        return "redirect:admin_category_list";


    }
}
