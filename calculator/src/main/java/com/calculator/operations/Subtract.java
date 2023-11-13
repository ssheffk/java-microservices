package com.calculator.operations;

import com.calculator.IOperation;
import com.calculator.exceptions.BoundaryException;

public class Subtract implements IOperation {
  @Override
  public double calculate(double firstNumber, double secondNumber) throws BoundaryException {
    if (firstNumber < 0 || secondNumber < 0) {
      throw new BoundaryException("Lower boundary: 0");
    }
    return firstNumber - secondNumber;
  }
}
