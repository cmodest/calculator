package com.iteriam.calculator.model;

import java.math.BigDecimal;

public interface Operation {

    Operation isThis(final String operation);

    BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2);
}
