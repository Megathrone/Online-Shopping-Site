package com.megathrone.tmall.service.impl;

import com.megathrone.tmall.mapper.UserMapper;
import com.megathrone.tmall.pojo.User;
import com.megathrone.tmall.pojo.UserExample;
import com.megathrone.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User c) {
        userMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(User c) {
        userMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list() {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id desc");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public boolean isExist(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        List<User> result = userMapper.selectByExample(userExample);
        if(!result.isEmpty()) return true;
        return false;
    }

    @Override
    public User get(String name, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> result = userMapper.selectByExample(example);
        if(result.isEmpty()) return null;
        return result.get(0);
    }
}
