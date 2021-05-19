package com.iteriam.calculator.model;

import java.math.BigDecimal;

public class Multiplication implements Operation{

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.multiply(operator2);
    }
}
