package com.calculator.operations;

import com.calculator.IOperation;
import com.calculator.exceptions.BoundaryException;
import com.calculator.exceptions.ZeroDivisionException;

public class Divide implements IOperation {
  @Override
  public double calculate(double firstNumber, double secondNumber) throws BoundaryException, ZeroDivisionException {

    if (secondNumber == 0) {
      throw new ZeroDivisionException();
    }
    if (firstNumber < 0 || secondNumber < 0) {
      throw new BoundaryException("Lower boundary: 0");
    }
    return firstNumber / secondNumber;
  }
}
