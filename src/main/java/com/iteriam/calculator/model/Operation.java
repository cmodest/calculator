package com.iteriam.calculator.model;

import java.math.BigDecimal;

public interface Operation {

    Boolean isThis(final String operation);

    Operation createNew();

    BigDecimal calculate(final BigDecimal operator1, final BigDecimal operator2);
}
