package com.iteriam.calculator.controllers;


import com.iteriam.calculator.exception.OperationException;
import com.iteriam.calculator.services.CalculatorService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("iteriam/api")
public class CalculatorController {

    private final TracerImpl tracer = new TracerImpl();

    @Autowired
    private CalculatorService calculatorService;


    @GetMapping("/calculate")
    public ResponseEntity<Object> calculate(@RequestParam(name = "operator1") BigDecimal operator1,
                                                @RequestParam(name = "operator2") BigDecimal operator2,
                                                @RequestParam(name = "operationType") String type) {
        try {
            final BigDecimal result = this.calculatorService.calculate(operator1, operator2, type);

            tracer.trace("The result of the operation is: " + result);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (OperationException e){
            tracer.trace("Operation not supported");
            return new ResponseEntity<>("Operation not supported",HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleServiceCallException(MethodArgumentTypeMismatchException e) {
        Map<String, String> errMessages = new HashMap<>();
        errMessages.put("error", "MethodArgumentTypeMismatchException");
        errMessages.put("message", e.getMessage());
        errMessages.put("parameter", e.getName());
        errMessages.put("errorCode", e.getErrorCode());
        return errMessages;
    }
}
