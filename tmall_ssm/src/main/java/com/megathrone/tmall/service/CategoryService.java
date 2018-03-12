package com.megathrone.tmall.service;

import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.util.Page;

import java.util.List;

public interface CategoryService {
    int total();
    List<Category> list(Page page);
    void add(Category category);
}
