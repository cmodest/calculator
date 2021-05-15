package com.iteriam.calculator.controllers;

import com.iteriam.calculator.Application;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest extends TestCase {

    @LocalServerPort
    int randomServerPort;

    private ResponseEntity<Double> calcula(double primero, double segundo, String operacion) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort +
                "/iteriam/api/calculate?operator1=" + primero +
                "&operator2=" + segundo + "&operationType=" + operacion;
        URI uri = new URI(baseUrl);

        ResponseEntity<Double> resultado = restTemplate.getForEntity(uri, Double.class);
        return resultado;
    }

    @Test
    public void testCalculate() {
        try {
            ResponseEntity<Double> resultado = calcula(1, 1, "add");
        }
        catch (Exception e){
            Assert.fail();
        }
    }
}