package com.iteriam.calculator.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculatorServiceImplTest {

    private CalculatorService calculatorService;

    @Before
    public void setUp() throws Exception {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void calculateAddTest() {
        BigDecimal result1 = calculatorService.calculate(new BigDecimal(10),new BigDecimal(1),"+");
        BigDecimal result2 = calculatorService.calculate(new BigDecimal(1),new BigDecimal(10),"add");
        BigDecimal result3 = calculatorService.calculate(new BigDecimal(1),new BigDecimal(10),"ADD");
        BigDecimal result4 = calculatorService.calculate(new BigDecimal(10),new BigDecimal(1),"Add");
        assertEquals(result1,result2);
        assertEquals(result3,result1);
        assertEquals(result2,result4);
    }

    @Test
    public void calculateMultiplicationTest() {
        BigDecimal result1 = calculatorService.calculate(new BigDecimal(10),new BigDecimal(1),"*");
        BigDecimal result2 = calculatorService.calculate(new BigDecimal(1),new BigDecimal(10),"multiplication");
        BigDecimal result3 = calculatorService.calculate(new BigDecimal(1),new BigDecimal(10),"MULTIPLICATION");
        BigDecimal result4 = calculatorService.calculate(new BigDecimal(10),new BigDecimal(1),"MultIPliCatiOn");
        assertEquals(result1,result2);
        assertEquals(result3,result1);
        assertEquals(result2,result4);
    }

    @Test
    public void calculateSubstractionTest() {
        BigDecimal result1 = calculatorService.calculate(new BigDecimal(10),new BigDecimal(1),"-");
        BigDecimal result2 = calculatorService.calculate(new BigDecimal(1),new BigDecimal(10),"substraction");
        BigDecimal result3 = calculatorService.calculate(new BigDecimal(1),new BigDecimal(10),"SUBSTRACTION");
        BigDecimal result4 = calculatorService.calculate(new BigDecimal(10),new BigDecimal(1),"subStraCTion");
        assertNotEquals(result1,result2);
        assertEquals(result4,result1);
        assertEquals(result2,result3);
    }

    @Test
    public void calculateDivisionTest() {
        BigDecimal result1 = calculatorService.calculate(new BigDecimal(10),new BigDecimal(1),"/");
        BigDecimal result2 = calculatorService.calculate(new BigDecimal(1),new BigDecimal(10),"division");
        BigDecimal result3 = calculatorService.calculate(new BigDecimal(1),new BigDecimal(10),"DIVISION");
        BigDecimal result4 = calculatorService.calculate(new BigDecimal(10),new BigDecimal(1),"DivISiOn");
        assertNotEquals(result1,result2);
        assertEquals(result4,result1);
        assertEquals(result2,result3);
    }

    @Test
    public void calculateSymbolExceptionTest(){
        try {
            calculatorService.calculate(new BigDecimal(1),new BigDecimal(10), "?");
        }
        catch (RuntimeException re){
            assertEquals(re.getClass(),RuntimeException.class);
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void calculateOperationExceptionTest(){
        try {
            calculatorService.calculate(new BigDecimal(1),new BigDecimal(10), "haz algo");
        }
        catch (RuntimeException re){
            assertEquals(re.getClass(),RuntimeException.class);
        }
        catch (Exception e){
            Assert.fail();
        }
    }

}