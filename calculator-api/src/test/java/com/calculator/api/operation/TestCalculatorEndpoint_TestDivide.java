package com.calculator.api.operation;

import com.calculator.api.dtos.CalculatorInputDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestCalculatorEndpoint_TestDivide {
  @Autowired
  TestRestTemplate restTemplate;

  @Test
  public void TestDivideWithValidInput() {
    CalculatorInputDto input = new CalculatorInputDto();
    input.setInput("8 / 4");

    ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/calculator", input ,String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("{\"response\":\"2.0\"}", response.getBody());
  }

  @Test
  public void TestDivideWithInvalidInput() {
    CalculatorInputDto input = new CalculatorInputDto();
    input.setInput("-4 / 8");

    ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/calculator", input ,String.class);
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
}
