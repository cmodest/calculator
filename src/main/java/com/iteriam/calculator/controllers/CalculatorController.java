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

@RestController
@RequestMapping("iteriam/api")
public class CalculatorController {

    private TracerImpl tracer = new TracerImpl();

    @Autowired
    CalculatorService calculatorService;


    @GetMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestParam(name = "operator1") String operator1,
                                            @RequestParam(name = "operator2") String operator2,
                                            @RequestParam(name = "operationType") String type) {

        double result = calculatorService.calculate(operator1,operator2,type);

        tracer.trace("The result of the operation is: " + result);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
