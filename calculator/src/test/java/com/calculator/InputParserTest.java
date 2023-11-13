package com.calculator;


import com.calculator.exceptions.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {


  @Test
  void noArguments_Provided() throws ParseException {
    assertThrows(ParseException.class, () -> new InputParser(""));
  }

  @Test
  void toManyArguments_Provided() throws ParseException {
    assertThrows(ParseException.class, () -> new InputParser("12.3/123 5"));
  }

  @Test
  void testFirstNumberField() throws ParseException {
    InputParser parser = new InputParser("12.1/3");
    assertEquals(12.1, parser.getFirstNumber());
  }

  @Test
  void testOperationField() throws ParseException {
    InputParser parser = new InputParser("12.1/3");
    assertEquals('/', parser.getSymbol());
  }
  @Test
  void testSecondNumberField() throws ParseException {
    InputParser parser = new InputParser("12.1/3");
    assertEquals(3, parser.getSecondNumber());
  }
}