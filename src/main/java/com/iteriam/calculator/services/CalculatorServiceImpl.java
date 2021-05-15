package com.iteriam.calculator.services;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private String operationType = "";
    private TracerImpl tracer = new TracerImpl();

    @Override
    public double calculate(String operator1, String operator2, String type){

        getOperation(type);
        Double op1 = Double.valueOf(operator1);
        Double op2 = Double.valueOf(operator2);

        switch (operationType){
            case "add":
                return op1 + op2;
            case "substraction":
                return op1 - op2;
            case "multiplication":
                return op1 * op2;
            case "division":
                return op1 / op2;
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
