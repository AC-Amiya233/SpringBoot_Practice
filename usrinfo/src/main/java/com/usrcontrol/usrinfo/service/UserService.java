package com.usrcontrol.usrinfo.service;

import com.usrcontrol.usrinfo.entity.User;

public interface UserService extends BaseService<User>{
    User findByName(String name);
}