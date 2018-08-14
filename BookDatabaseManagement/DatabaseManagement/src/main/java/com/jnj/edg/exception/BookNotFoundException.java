package com.jnj.edg.exception;
/*
Author:
Description:异常处理
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String exception) {
        super(exception);
    }
}
