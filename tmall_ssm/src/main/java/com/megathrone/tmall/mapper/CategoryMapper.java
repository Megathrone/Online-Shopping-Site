package com.megathrone.tmall.mapper;

import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
    List<Category> list(Page page);

    public int total();

    void add(Category category);

    void delete(int id);

    Category get(int id);
}
