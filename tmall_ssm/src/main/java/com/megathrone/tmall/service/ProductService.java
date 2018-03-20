package com.megathrone.tmall.service;

import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.pojo.Product;

import java.util.List;

public interface ProductService {

    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    //void setFirstProductImage(Product p);
    void fill(List<Category> cs);

    void fill(Category c);

    void fillByRow(List<Category> cs);
}
