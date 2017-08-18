package com.example.girl.exception;

public class GirlsException extends RuntimeException {

    private Integer code;

    public GirlsException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
