package com.example.demo.dto;

import com.example.demo.enums.ErrorCode;

/**
 * Created By : arshia on 06/02/21
 **/
public class ErrorResponseDto {

    private ErrorCode errorCode;
    private String message;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
