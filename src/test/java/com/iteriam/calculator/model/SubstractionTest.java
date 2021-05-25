package com.iteriam.calculator.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubstractionTest {

    public static Substraction substraction;

    @Test
    void isThis() {
        substraction = new Substraction();
        substraction.isThis("-");
        assertTrue(Objects.nonNull(substraction));
    }

    @Test
    void calculate() {
        substraction = new Substraction();
        BigDecimal result = substraction.calculate(new BigDecimal(1), new BigDecimal(1));
        assertEquals(new BigDecimal(0),result);
    }
}