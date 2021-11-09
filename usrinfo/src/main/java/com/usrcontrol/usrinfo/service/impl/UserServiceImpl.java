package com.usrcontrol.usrinfo.service.impl;

import com.usrcontrol.usrinfo.entity.User;
import com.usrcontrol.usrinfo.mapper.UserMapper;
import com.usrcontrol.usrinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void create(User usr){
        userMapper.create(usr);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids) {
            userMapper.delete(id);
        }
    }

    @Override
    public void update(User usr) {
        userMapper.update(usr);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
