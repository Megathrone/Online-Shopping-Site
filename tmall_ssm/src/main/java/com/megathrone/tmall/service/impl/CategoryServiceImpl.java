package com.megathrone.tmall.service.impl;

import com.megathrone.tmall.mapper.CategoryMapper;
import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> list(){
        return categoryMapper.list();
    };

}