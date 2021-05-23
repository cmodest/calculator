package com.iteriam.calculator.services;

import com.iteriam.calculator.exception.OperationException;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal calculate (final BigDecimal operator1, final BigDecimal operator2, final String type) throws OperationException;
}
