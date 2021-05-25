package com.iteriam.calculator.services;

import com.iteriam.calculator.exception.OperationException;
import com.iteriam.calculator.model.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

class CalculatorServiceImplTest {

    private static CalculatorService calculatorService;

    @BeforeAll
    public static void setup(){
        Addition addition = new Addition();
        Substraction substraction = new Substraction();
        Multiplication multiplication = new Multiplication();
        Division division = new Division();
        List<Operation> operations = Arrays.asList(addition,substraction,multiplication,division);
        calculatorService = new CalculatorServiceImpl(operations);
    }

    @Test
    void calculate() {
        try {

            assertEquals(calculatorService.calculate(new BigDecimal(2), new BigDecimal(2), "+"),
                    calculatorService.calculate(new BigDecimal(2), new BigDecimal(2), "*"));
            assertNotEquals(calculatorService.calculate(new BigDecimal(2), new BigDecimal(2), "-"),
            calculatorService.calculate(new BigDecimal(2), new BigDecimal(2), "/"));
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    void calculateException() {
        try {
            calculatorService.calculate(new BigDecimal(2), new BigDecimal(2), "sub");
        }
        catch (Exception e){
            assertEquals(e.getClass(), OperationException.class);
        }
    }
}