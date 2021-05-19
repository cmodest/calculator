package com.iteriam.calculator.model;

import java.math.BigDecimal;

public class Substraction implements Operation{

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.subtract(operator2);
    }
}
