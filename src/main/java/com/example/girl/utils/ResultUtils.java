package com.example.girl.utils;

import com.example.girl.domain.Result;
import com.example.girl.enums.ResultEnum;

public class ResultUtils {

    public static Result success(Object object, ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);

        return result;
    }

    public static Result success() {
        //return success(null);
        return success("", ResultEnum.SUCCESS);
    }


    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        //result.setData(null);
        result.setData("");

        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        //result.setData(null);
        result.setData("");

        return result;
    }


}
