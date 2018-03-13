package com.megathrone.tmall.mapper;

import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {

    //重构方法
    List<Category> list();


    void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);
}
