package com.zchi.qhdfldemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Result<T> {
//    private boolean success;
    private String code;
    private String message;
    private T data;

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
