package com.iteriam.calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division implements Operation{

    @Override
    public BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2){
        return operator1.divide(operator2, RoundingMode.HALF_UP);
    }
}
