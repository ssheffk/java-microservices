package com.calculator.operations;

import com.calculator.OperationFactory;
import com.calculator.IOperation;
import com.calculator.exceptions.BoundaryException;
import com.calculator.exceptions.OperationsException;
import com.calculator.exceptions.ZeroDivisionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    private IOperation calculator;
  @BeforeEach
  public void setUp() throws OperationsException {
    calculator = OperationFactory.createOperation('+');
  }

  @Test
  void testAddTwoNumbers_ValidInputs() throws BoundaryException, ZeroDivisionException {
    assertEquals(2.0, calculator.calculate(1, 1));
  }
  @Test
  void testAddTwoNumbers_NegativeInputs() throws BoundaryException, ZeroDivisionException {
    assertThrows(BoundaryException.class, () -> calculator.calculate(-1, 1));
  }
}