package com.example.demo.exceptions.runtimeExceptions;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintViolation;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created By : arshia on 12/12/20
 **/
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public <T> BadRequestException(Set<ConstraintViolation<T>> errors) {
        super(getErrorMessage(errors));
    }

    private static <T> String getErrorMessage(Set<ConstraintViolation<T>> errors) {
        List<String> messages = new LinkedList<>();
        for (ConstraintViolation error : errors) {
            messages.add("Param '" + error.getPropertyPath() + "' " + error.getMessage());
        }
        return StringUtils.join(messages, ", ");
    }
}
