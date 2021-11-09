package com.usrcontrol.usrinfo.mapper;

import com.usrcontrol.usrinfo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    List<User> findById(long id);
    void create(User user);
    void delete(Long id);
    void update(User user);
    User findByName(String name);
}
