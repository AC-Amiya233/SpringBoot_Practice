package com.usrcontrol.usrinfo.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    List<T> findById(Long id);
    void create(T t);
    void delete(Long... ids);
    void update(T t);
}
