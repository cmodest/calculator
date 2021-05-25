package com.iteriam.calculator.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    public static Addition addition;

    @Test
    void isThis() {
        addition = new Addition();
        addition.isThis("add");
        assertTrue(Objects.nonNull(addition));
    }

    @Test
    void calculate() {
        addition = new Addition();
        BigDecimal result = addition.calculate(new BigDecimal(1), new BigDecimal(1));
        assertEquals(new BigDecimal(2),result);
    }
}