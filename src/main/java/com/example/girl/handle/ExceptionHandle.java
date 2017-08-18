package com.example.girl.handle;

import com.example.girl.domain.Result;
import com.example.girl.enums.ResultEnum;
import com.example.girl.exception.GirlsException;
import com.example.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        if (e instanceof GirlsException) {
            GirlsException girlsException = (GirlsException) e;
            return ResultUtils.error(girlsException.getCode(), girlsException.getMessage());
        } else {
            LOGGER.error("系统异常：{}", e);
            return ResultUtils.error(ResultEnum.UNKNOWN_ERROR);
        }

    }


}
