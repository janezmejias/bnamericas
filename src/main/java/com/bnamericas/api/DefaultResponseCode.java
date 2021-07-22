package com.bnamericas.api;

import org.springframework.http.HttpStatus;

/**
 *
 * @author janez
 */
public class DefaultResponseCode {

    public static final String SUCCESS = "success";
    public static final Integer SUCCESS_CODE = 0;
    public static final Integer DEFAULT_ERROR_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();

}
