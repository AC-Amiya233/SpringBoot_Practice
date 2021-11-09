package com.usrcontrol.usrinfo.mapper;

import com.github.pagehelper.Page;
import com.usrcontrol.usrinfo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> findAll();
    Page<Goods> findByPage(Goods goods);
    List<Goods> findById(Long id);
    void create(Goods goods);
    void update(Goods goods);
    void delete(Long id);
}
