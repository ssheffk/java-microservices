package com.calculator.api.dtos;


public class CalculatorResponseDto {
  private final String response;

  public CalculatorResponseDto( String response) {

    this.response = response;
  }

  public String getResponse() {
    return response;
  }
}
