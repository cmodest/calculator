package com.iteriam.calculator.model;

import java.math.BigDecimal;

public interface Operation {

    BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2);
}
