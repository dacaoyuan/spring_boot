package com.example.girl.utils;

import com.example.girl.domain.Result;

public class ResultUtils {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);

        return result;
    }

    public static Result success() {
        //return success(null);
        return success("");
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
