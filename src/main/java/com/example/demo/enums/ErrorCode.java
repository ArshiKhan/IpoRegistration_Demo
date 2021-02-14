package com.example.demo.enums;

/**
 * Created By : arshia on 06/02/21
 **/
public enum ErrorCode {
    INTERNAL_SERVER_ERROR,
    ENTITY_NOT_FOUND,
    PAGE_NOT_FOUND,
    METHOD_NOT_SUPPORTED,
    CONTENT_TYPE_NOT_SUPPORTED,
    PARAM_MISSING,
    PARAM_INVALID,
    REQUEST_NOT_READABLE,
    SERVICE_UNAVAILABLE,
    BAD_REQUEST,
    TOO_MANY_REQUESTS,
    ILLEGAL_ARGUMENTS,
    FORBIDDEN;

    @Override
    public String toString() {
        return this.name();
    }
}
