package com.iteriam.calculator.controllers;


import io.corp.calculator.TracerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("iteriam/api")
public class CalculatorController {

    private TracerImpl tracer = new TracerImpl();

    @GetMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestParam(name = "operator1") String operator1,
                                            @RequestParam(name = "operator2") String operator2,
                                            @RequestParam(name = "operationType") String type) {

        double result = Integer.valueOf(operator1) + Integer.valueOf(operator2);

        tracer.trace(result);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
