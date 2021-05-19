package com.iteriam.calculator.model;

import java.math.BigDecimal;

public class Addition implements Operation{

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.add(operator2);
    }
}
