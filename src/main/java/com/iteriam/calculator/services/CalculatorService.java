package com.iteriam.calculator.services;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal calculate (BigDecimal operator1, BigDecimal operator2, String type);
}
