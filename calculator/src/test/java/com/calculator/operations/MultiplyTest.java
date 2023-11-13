package com.calculator.operations;

import com.calculator.OperationFactory;
import com.calculator.IOperation;
import com.calculator.exceptions.BoundaryException;
import com.calculator.exceptions.OperationsException;
import com.calculator.exceptions.ZeroDivisionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {

  private IOperation calculator;
  @BeforeEach
  public void setUp() throws OperationsException {
    calculator = OperationFactory.createOperation('*');
  }

  @Test
  void testMultiplyTwoNumbers_ValidInputs() throws BoundaryException, ZeroDivisionException {
    assertEquals(9.0, calculator.calculate(3, 3));

  }
  @Test
  void testMultiplyTwoNumbers_NegativeInputs() {
    assertThrows(BoundaryException.class, () ->
      calculator.calculate(-1, 1)
    );
  }

}