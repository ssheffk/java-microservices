package com.calculator.api.exceptions;
import com.calculator.api.controllers.CalculatorController;
import com.calculator.api.dtos.CalculatorResponseDto;

import com.calculator.exceptions.BoundaryException;
import com.calculator.exceptions.OperationsException;
import com.calculator.exceptions.ParseException;
import com.calculator.exceptions.ZeroDivisionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
  private Logger logger = LoggerFactory.getLogger(CalculatorController.class);


  @ExceptionHandler({BoundaryException.class, ZeroDivisionException.class, OperationsException.class, ParseException.class})
  private ResponseEntity<CalculatorResponseDto> handleClientExceptionException(Exception ex) {

    this.logger.warn(ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CalculatorResponseDto("Bad request, check your input"));
  }

  @ExceptionHandler(Exception.class)
  private ResponseEntity<CalculatorResponseDto> handleInternalException(Exception ex) {
    this.logger.error(ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CalculatorResponseDto("Something went wrong"));
  }
}
