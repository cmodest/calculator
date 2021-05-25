package com.iteriam.calculator.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Multiplication implements Operation{

    @Override
    public Boolean isThis(final String operation){
        if(operation.equalsIgnoreCase("multiplication") || operation.equals("*")){
            return true;
        }
        return false;
    }

    @Override
    public Operation createNew(){
        return new Multiplication();
    }

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.multiply(operator2);
    }
}
