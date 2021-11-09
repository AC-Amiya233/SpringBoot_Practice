package com.usrcontrol.usrinfo.controller.admin;

import com.usrcontrol.usrinfo.entity.Goods;
import com.usrcontrol.usrinfo.entity.PageBean;
import com.usrcontrol.usrinfo.entity.Result;
import com.usrcontrol.usrinfo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/findByConPage")
    public PageBean findByConPage(Goods goods,
                                  @RequestParam(value = "pageCode", required = false) int pageCode,
                                  @RequestParam(value = "pageSize", required = false) int pageSize) {
        return goodsService.findByPage(goods, pageCode, pageSize);
    }

    @RequestMapping("/create")
    public Result create(@RequestBody Goods goods) {
        try {
            goodsService.create(goods);
            return new Result(true, "Success");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Unknown Error");
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Goods goods) {
        try {
            goodsService.update(goods);
            return new Result(true, "Success");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Unknown Error");
        }
    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody Long... ids) {
        try{
            goodsService.delete((ids));
            return new Result(true, "Success");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Unknown Error");
        }
    }

    @RequestMapping("/findById")
    public List<Goods> findById(@RequestParam(value = "id", required = false) Long id) {
        return goodsService.findById(id);
    }
}
