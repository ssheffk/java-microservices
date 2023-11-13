package com.calculator.api.controllers;

import com.calculator.api.dtos.CalculatorInputDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest {

  @Autowired
  TestRestTemplate restTemplate;

  @Test
  public void calculatorControllerGetOperationsEndpoint() {
    ResponseEntity<String> response = restTemplate.getForEntity("/api/v1/calculator/operations", String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());

  }

  @Test
  public void calculatorControllerTestCalculatorEndPoint() {
    CalculatorInputDto input = new CalculatorInputDto();
    input.setInput("2+2");

    ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/calculator", input ,String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }
  @Test
  public void calculatorControllerTestCalculatorEndPointWithNotValidInput() {
    CalculatorInputDto input = new CalculatorInputDto();
    input.setInput("2 ! 2");

    ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/calculator", input ,String.class);
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void calculatorControllerTestCalculatorEndPointNotProvidedInput() {
    CalculatorInputDto input = new CalculatorInputDto();
    input.setInput(null);

    ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/calculator", input ,String.class);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
  }
}