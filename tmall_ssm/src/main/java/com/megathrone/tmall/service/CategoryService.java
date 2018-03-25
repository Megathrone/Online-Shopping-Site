package com.megathrone.tmall.service;

import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.util.Page;

import java.util.List;

public interface CategoryService {

    List<Category> list();
    void add(Category category);
    void delete(int id);
    Category get(int id);
    void update(Category category);
}
