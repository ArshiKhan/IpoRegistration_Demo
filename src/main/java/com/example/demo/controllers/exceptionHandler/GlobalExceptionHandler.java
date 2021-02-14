package com.example.demo.controllers.exceptionHandler;

import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.enums.ErrorCode;
import com.example.demo.exceptions.runtimeExceptions.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

/**
 * Created By : arshia on 06/02/21
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleBadRequestException(BadRequestException ex) {
        logger.error("BadRequestException: {}", ex.getMessage(),ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error("MethodArgumentNotValidException: {}", ex.getMessage(),ex);
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String errorMessage = "Param " + fieldError.getField() + " = '" + fieldError.getRejectedValue() + "' "
                + fieldError.getDefaultMessage();
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.PARAM_INVALID, errorMessage);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("IllegalArgumentException: {}", ex.getMessage(), ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.ILLEGAL_ARGUMENTS, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFoundException(EntityNotFoundException ex) {
        logger.error("EntityNotFoundException", ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.ENTITY_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
