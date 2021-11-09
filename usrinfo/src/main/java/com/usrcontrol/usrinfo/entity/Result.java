package com.usrcontrol.usrinfo.entity;

import lombok.Data;

/**
 * A POJO class for 1/0 event
 */
@Data
public class Result {
    private boolean success;
    private String message;

    public Result(boolean success, String username) {
        this.success = success;
        this.message = username;
    }
}
