package com.iteriam.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class OperationException extends RuntimeException {

    public OperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
