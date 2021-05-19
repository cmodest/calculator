package com.iteriam.calculator.controllers;


import com.iteriam.calculator.services.CalculatorService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("iteriam/api")
public class CalculatorController {

    private final TracerImpl tracer = new TracerImpl();

    @Autowired
    private CalculatorService calculatorService;


    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calculate(@RequestParam(name = "operator1") BigDecimal operator1,
                                                @RequestParam(name = "operator2") BigDecimal operator2,
                                                @RequestParam(name = "operationType") String type) {

        final BigDecimal result = this.calculatorService.calculate(operator1,operator2,type);

        tracer.trace("The result of the operation is: " + result);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
