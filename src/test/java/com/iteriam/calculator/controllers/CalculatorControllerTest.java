package com.iteriam.calculator.controllers;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CalculatorController.class)
public class CalculatorControllerTest extends TestCase {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CalculatorController calculatorController;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    public void testCalculate() {
        try{
            mockMvc.perform(get("/iteriam/api/calculate/?operator1=1&operator2=1&operationType=+")).andExpect(status().isOk());
        }
        catch (Exception e){
            Assert.fail();
        }
    }
}