package com.usrcontrol.usrinfo.entity;

import lombok.Data;

import java.util.List;

/**
 * A POJO class for displaying state
 */
@Data
public class PageBean {
    private long total;
    private List rows;

    public PageBean(long total, List<Goods> result) {
        this.total = total;
        this.rows = result;
    }
}
