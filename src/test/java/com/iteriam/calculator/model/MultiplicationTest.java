package com.iteriam.calculator.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiplicationTest {

    public static Multiplication multiplication;

    @Test
    void isThis() {
        multiplication = new Multiplication();
        multiplication.isThis("add");
        assertTrue(Objects.nonNull(multiplication));
    }

    @Test
    void calculate() {
        multiplication = new Multiplication();
        BigDecimal result = multiplication.calculate(new BigDecimal(1), new BigDecimal(1));
        assertTrue(result.equals(new BigDecimal(1)));
    }
}