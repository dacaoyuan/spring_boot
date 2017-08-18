package com.example.girl.exception;

import com.example.girl.enums.ResultEnum;

public class GirlsException extends RuntimeException {

    private Integer code;

    //public ResultEnum resultEnum;

    public GirlsException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        code = resultEnum.getCode();
        //this.resultEnum = resultEnum;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
