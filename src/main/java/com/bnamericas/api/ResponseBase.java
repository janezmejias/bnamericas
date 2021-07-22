package com.bnamericas.api;

import static com.bnamericas.api.DefaultResponseCode.DEFAULT_ERROR_CODE;
import static com.bnamericas.api.DefaultResponseCode.SUCCESS;
import static com.bnamericas.api.DefaultResponseCode.SUCCESS_CODE;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseBase {

    private Integer code;
    private String message;
    private Object body;

    public static ResponseBase buildSuccessResponse(Object body) {
        return ResponseBase.builder()
                .code(SUCCESS_CODE)
                .message(SUCCESS)
                .body(body)
                .build();
    }

    public static ResponseBase buildSuccessWithOutBodyResponse() {
        return ResponseBase.builder()
                .code(SUCCESS_CODE)
                .message(SUCCESS)
                .build();
    }

    public static ResponseBase buildErrorResponse(String errorMessage) {
        return ResponseBase.builder()
                .code(DEFAULT_ERROR_CODE)
                .message(errorMessage)
                .build();
    }

}
