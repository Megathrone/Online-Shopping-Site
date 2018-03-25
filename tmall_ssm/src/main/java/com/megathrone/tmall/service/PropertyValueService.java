package com.megathrone.tmall.service;

import com.megathrone.tmall.pojo.Product;
import com.megathrone.tmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {

    void init(Product p);
    void update(PropertyValue pv);

    PropertyValue get(int ptid, int pid);
    List<PropertyValue> list(int pid);
}
