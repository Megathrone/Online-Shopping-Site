package com.megathrone.tmall.controller;

import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.service.CategoryService;
import com.megathrone.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        int total;
        List<Category> cs= categoryService.list(page);
        total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page",page);
        return "admin/listCategory";
    }


}