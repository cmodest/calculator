package com.iteriam.calculator.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Addition implements Operation{

    @Override
    public Boolean isThis(final String operation){
        return operation.equalsIgnoreCase("add") || operation.equals("+");
    }

    @Override
    public Operation createNew(){
        return new Addition();
    }

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.add(operator2);
    }
}
