package com.megathrone.tmall.service;

import com.megathrone.tmall.pojo.User;

import java.util.List;

public interface UserService {

    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
}
