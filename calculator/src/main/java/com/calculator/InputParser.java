package com.calculator;

import com.calculator.exceptions.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
  private double firstNumber;
  private double secondNumber;
  private char symbol;

  public InputParser(String arguments) throws ParseException {
   parse(arguments);
  }

  private void parse(String args) throws ParseException {

    if (args.length() < 1) {
      throw  new ParseException("No arguments provided");
    }

    String trimmedString = args.replaceAll("\\s", "");
    char extractedSymbol = trimmedString.replaceAll("[\\d.]", "").charAt(0);

    Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    List<String> numbers = new ArrayList<String>();
    Matcher m = pattern.matcher(args);
    while (m.find()) {
      numbers.add(m.group());
    }

    if(numbers.size() != 2) {
      throw  new ParseException("Three arguments needed for expression");
    }
    this.firstNumber = Double.parseDouble(numbers.get(0));
    this.secondNumber = Double.parseDouble(numbers.get(1));
    this.symbol = extractedSymbol;
  }

  public double getFirstNumber() {
    return firstNumber;
  }

  public double getSecondNumber() {
    return secondNumber;
  }

  public char getSymbol() {
    return symbol;
  }
}
