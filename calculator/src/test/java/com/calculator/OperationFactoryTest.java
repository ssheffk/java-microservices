package com.calculator;

import com.calculator.exceptions.OperationsException;
import com.calculator.exceptions.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationFactoryTest {

  @Test
  void test_InvalidSymbolInputs() {
    assertThrows(OperationsException.class, () ->
        OperationFactory.createOperation('!')
    );
  }
  @Test
  void test_addOperation() throws OperationsException {
    assertDoesNotThrow( () -> OperationFactory.createOperation('+'));
  }

  @Test
  void test_divideOperation() throws OperationsException {
    assertDoesNotThrow( () -> OperationFactory.createOperation('/'));
  }
  @Test
  void test_multiplyOperation() throws OperationsException {
    assertDoesNotThrow( () -> OperationFactory.createOperation('*'));
  }
  @Test
  void test_subtractOperation() throws OperationsException {
    assertDoesNotThrow( () -> OperationFactory.createOperation('-'));
  }

}