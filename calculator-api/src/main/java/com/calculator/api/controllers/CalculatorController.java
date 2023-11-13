package com.calculator.api.controllers;
import com.calculator.IOperation;
import com.calculator.InputParser;
import com.calculator.OperationFactory;
import com.calculator.api.dtos.CalculatorResponseDto;
import com.calculator.api.dtos.CalculatorInputDto;
import com.calculator.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

  @GetMapping("/api/v1/calculator/operations")
  @ResponseBody
  public ResponseEntity<CalculatorResponseDto> supportedOperations() {
    return ResponseEntity.status(HttpStatus.OK).body(new CalculatorResponseDto("We currently support: add, subtract, divide, multiply"));
  }

  @PostMapping("/api/v1/calculator")
  @ResponseBody
  public ResponseEntity<CalculatorResponseDto> calculator(@RequestBody CalculatorInputDto input) throws ParseException, OperationsException, BoundaryException, ZeroDivisionException {
    InputParser inputParser = new InputParser(input.getInput());
    IOperation operation = OperationFactory.createOperation(inputParser.getSymbol());
    double result = operation.calculate(inputParser.getFirstNumber(), inputParser.getSecondNumber());
    return  ResponseEntity.status(HttpStatus.OK).body(new CalculatorResponseDto(Double.toString(result)));
  }
}
