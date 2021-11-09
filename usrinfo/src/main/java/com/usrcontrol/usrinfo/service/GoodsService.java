package com.usrcontrol.usrinfo.service;

import com.usrcontrol.usrinfo.entity.Goods;
import com.usrcontrol.usrinfo.entity.PageBean;

public interface GoodsService extends BaseService<Goods>{
    PageBean findByPage(Goods goods, int pageCode, int pageSize);
}
