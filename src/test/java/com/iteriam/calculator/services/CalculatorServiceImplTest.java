package com.iteriam.calculator.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorServiceImplTest {

    private CalculatorService calculatorService;

    @Before
    public void setUp() throws Exception {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void calculateAddTest() {
        double result1 = calculatorService.calculate("10","1","+");
        double result2 = calculatorService.calculate("1","10","add");
        double result3 = calculatorService.calculate("1","10","ADD");
        double result4 = calculatorService.calculate("10","1","Add");
        assertEquals(result1,result2,0);
        assertEquals(result3,result1,0);
        assertEquals(result2,result4,0);
    }

    @Test
    public void calculateMultiplicationTest() {
        double result1 = calculatorService.calculate("10","1","*");
        double result2 = calculatorService.calculate("1","10","multiplication");
        double result3 = calculatorService.calculate("1","10","MULTIPLICATION");
        double result4 = calculatorService.calculate("10","1","MultIPliCatiOn");
        assertEquals(result1,result2,0);
        assertEquals(result3,result1,0);
        assertEquals(result2,result4,0);
    }

    @Test
    public void calculateSubstractionTest() {
        double result1 = calculatorService.calculate("10","1","-");
        double result2 = calculatorService.calculate("1","10","substraction");
        double result3 = calculatorService.calculate("1","10","SUBSTRACTION");
        double result4 = calculatorService.calculate("10","1","subStraCTion");
        assertNotEquals(result1,result2,0);
        assertEquals(result4,result1,0);
        assertEquals(result2,result3,0);
    }

    @Test
    public void calculateDivisionTest() {
        double result1 = calculatorService.calculate("10","1","/");
        double result2 = calculatorService.calculate("1","10","division");
        double result3 = calculatorService.calculate("1","10","DIVISION");
        double result4 = calculatorService.calculate("10","1","DivISiOn");
        assertNotEquals(result1,result2,0);
        assertEquals(result4,result1,0);
        assertEquals(result2,result3,0);
    }

    @Test
    public void calculateExceptionTest(){
        try {
            double result = calculatorService.calculate("10", "1", "?");
        }
        catch (RuntimeException re){
            assertEquals(re.getClass(),RuntimeException.class);
        }
        try {
            double result = calculatorService.calculate("10", "1", "alghai");
        }
        catch (RuntimeException re){
            assertEquals(re.getClass(),RuntimeException.class);
        }
    }
}