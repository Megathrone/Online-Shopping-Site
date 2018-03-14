package com.megathrone.tmall.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.pojo.Property;
import com.megathrone.tmall.service.CategoryService;
import com.megathrone.tmall.service.PropertyService;
import com.megathrone.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;

    @RequestMapping("admin_property_add")
    public String add(Model model, Property p){
        propertyService.add(p);
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String delete(int id){
        Property p = propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    @RequestMapping("admin_property_edit")
    public String edit(Model model,int id){
        Property p = propertyService.get(id);
        Category category = categoryService.get(p.getCid());
        p.setCategory(category);
        model.addAttribute("p",p);

        return "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public String update(Property p){
        propertyService.update(p);
        return "redirect:admin_property_list?cid="+p.getCid();
    }

    @RequestMapping("admin_property_list")
    public String list(int cid, Model model, Page page){
        Category category = categoryService.get(cid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Property> propertyList = propertyService.list(cid);

        int total = (int) new PageInfo<>(propertyList).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+category.getId());

        model.addAttribute("ps",propertyList);
        model.addAttribute("c",category);
        model.addAttribute("page",page);

        return "admin/listProperty";
    }
}
