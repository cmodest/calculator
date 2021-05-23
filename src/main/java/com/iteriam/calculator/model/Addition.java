package com.iteriam.calculator.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Addition implements Operation{

    @Override
    public Operation isThis(final String operation){
        if(operation.equalsIgnoreCase("add") || operation.equals("+")){
            return new Addition();
        }
        return null;
    }

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.add(operator2);
    }
}
