package com.calculator;

import com.calculator.exceptions.BoundaryException;
import com.calculator.exceptions.ZeroDivisionException;

public interface IOperation {
  double calculate(double firstNumber, double secondNumber) throws BoundaryException, ZeroDivisionException;
}
