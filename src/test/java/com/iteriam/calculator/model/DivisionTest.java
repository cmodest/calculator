package com.iteriam.calculator.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DivisionTest {

    public static Division division;

    @Test
    void isThis() {
        division = new Division();
        division.isThis("add");
        assertTrue(Objects.nonNull(division));
    }

    @Test
    void calculate() {
        division = new Division();
        BigDecimal result = division.calculate(new BigDecimal(1), new BigDecimal(1));
        assertTrue(result.equals(new BigDecimal(1)));
    }
}