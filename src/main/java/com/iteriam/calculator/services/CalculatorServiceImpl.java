package com.iteriam.calculator.services;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private String operationType = "";
    private TracerImpl tracer = new TracerImpl();

    @Override
    public BigDecimal calculate(BigDecimal operator1, BigDecimal operator2, String type){

        getOperation(type);


        switch (operationType){
            case "add":
                return operator1.add(operator2);
            case "substraction":
                return operator1.subtract(operator2);
            case "multiplication":
                return operator1.multiply(operator2);
            case "division":
                return operator1.divide(operator2);
            default:
                tracer.trace("ERROR: Operation not supported " + type);
                throw new RuntimeException("Operation not supported "  +type);
        }
    }

    private void getOperation(String operation){

        if(operation.length() > 1){
            operationType = operation.toLowerCase();
        }
        else {
            switch (operation){
                case "+":
                    operationType = "add";
                    break;
                case "-":
                    operationType = "substraction";
                    break;
                case "*":
                    operationType = "multiplication";
                    break;
                case "/":
                    operationType = "division";
                    break;
                default:
                    tracer.trace("ERROR: Operation not supported " + operation);
                    throw new RuntimeException("Operation not supported " + operation);
            }
        }
    }
}
