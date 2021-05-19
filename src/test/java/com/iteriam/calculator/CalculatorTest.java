package com.iteriam.calculator;

import com.iteriam.calculator.Application;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorTest extends TestCase {

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
    public void testCalculateAddition() {
        try {
            ResponseEntity<Double> resultado = calcula(1, 1, "add");
            assertEquals(200, resultado.getStatusCodeValue());
            assertEquals(2.0, resultado.getBody());
            ResponseEntity<Double> resultado2 = calcula(1, 1, "%2B");
            assertEquals(200, resultado2.getStatusCodeValue());
            assertEquals(resultado.getBody(), resultado.getBody());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testCalculateSubstraction() {
        try {
            ResponseEntity<Double> resultado = calcula(1, 1, "substraction");
            assertEquals(200, resultado.getStatusCodeValue());
            assertEquals(0.0, resultado.getBody());
            ResponseEntity<Double> resultado2 = calcula(1, 1, "-");
            assertEquals(200, resultado2.getStatusCodeValue());
            assertEquals(resultado.getBody(), resultado.getBody());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testCalculateMultiplication() {
        try {
            ResponseEntity<Double> resultado = calcula(10, 1, "multiplication");
            assertEquals(200, resultado.getStatusCodeValue());
            assertEquals(10.0, resultado.getBody());
            ResponseEntity<Double> resultado2 = calcula(10, 1, "*");
            assertEquals(200, resultado2.getStatusCodeValue());
            assertEquals(resultado.getBody(), resultado.getBody());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testCalculateDivision() {
        try {
            ResponseEntity<Double> resultado = calcula(10, 2, "division");
            assertEquals(200, resultado.getStatusCodeValue());
            assertEquals(5.0, resultado.getBody());
            ResponseEntity<Double> resultado2 = calcula(10, 2, "%2F");
            assertEquals(200, resultado2.getStatusCodeValue());
            assertEquals(resultado.getBody(), resultado.getBody());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testCalculateError() {
        try {
            ResponseEntity<Double> resultado = calcula(10, 2, "operation");
        }
        catch (Exception e){
            assertEquals(((HttpServerErrorException.InternalServerError) e).getRawStatusCode() , 500);
        }
    }

    @Test
    public void contextLoads() {
        Application.main(new String[0]);
    }
}