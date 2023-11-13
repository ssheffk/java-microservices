package com.calculator.exceptions;

public class ZeroDivisionException extends Exception {
  private static final String error = "Dividing by zero not allowed";
  public ZeroDivisionException() {super(error);}
}
