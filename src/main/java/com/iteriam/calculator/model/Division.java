package com.iteriam.calculator.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class Division implements Operation{

    @Override
    public Operation isThis(final String operation){
        if(operation.equalsIgnoreCase("division") || operation.equals("/")){
            return new Division();
        }
        return null;
    }

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.divide(operator2, RoundingMode.HALF_UP);
    }
}
