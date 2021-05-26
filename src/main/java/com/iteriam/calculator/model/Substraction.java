package com.iteriam.calculator.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Substraction implements Operation{

    @Override
    public Boolean isThis(final String operation){
        return operation.equalsIgnoreCase("substraction") || operation.equals("-");
    }

    @Override
    public Operation createNew(){
        return new Substraction();
    }

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.subtract(operator2);
    }
}
