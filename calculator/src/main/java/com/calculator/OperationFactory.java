package com.calculator;


import com.calculator.exceptions.OperationsException;
import com.calculator.operations.Add;
import com.calculator.operations.Divide;
import com.calculator.operations.Multiply;
import com.calculator.operations.Subtract;

import java.util.HashMap;
import java.util.Map;


public class OperationFactory {
  private static final Map<Character, IOperation> operationsMap = new HashMap<>(){{
    put('+', new Add());
    put('-', new Subtract());
    put('/', new Divide());
    put('*', new Multiply());
  }};

 public static IOperation createOperation(char operation) throws OperationsException {
   if (operationsMap.get(operation) == null) {
     throw new OperationsException("Currently allowed operations: + - / *, with only positive numbers");
   }
   return operationsMap.get(operation);
 }
}
