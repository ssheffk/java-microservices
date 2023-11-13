package com.calculator;


import com.calculator.exceptions.BoundaryException;
import com.calculator.exceptions.OperationsException;
import com.calculator.exceptions.ParseException;
import com.calculator.exceptions.ZeroDivisionException;

public class App {
  public static void main(String[] args)  {


    try {
      InputParser parser = new InputParser(args[0]);
      IOperation operation = OperationFactory.createOperation(parser.getSymbol());
      System.out.println(operation.calculate(parser.getFirstNumber(), parser.getSecondNumber()));
    }catch (BoundaryException | ZeroDivisionException e) {
      System.out.println("Please use only positive numbers, and cannot divide by zero.");
    }catch (ParseException | OperationsException e) {
      System.out.println("Program works with three arguments and operations: + - / *");
    }catch (Exception e) {
      System.out.println("Something went wrong");
    }
  }
}
