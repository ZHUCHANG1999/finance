package com.atguigu.common.exception;

import com.atguigu.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class UnifiedException {
    // 捕获所有异常
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e){
        log.error(e.getMessage(),e);
        return R.error();
    }

}
