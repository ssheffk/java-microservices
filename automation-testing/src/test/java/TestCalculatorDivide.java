import calculator.CalculatorRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculatorDivide {
  private CalculatorRunner calculatorRunner;
  @BeforeEach
  public void setUp()  {
    calculatorRunner = new CalculatorRunner();
  }
  @Test
  public void testDivideWithValidArguments() throws IOException {

    assertEquals("5.0", calculatorRunner.executeCalculation("10/2"));
  }


  @ParameterizedTest
  @ValueSource(strings = {"-2/2", "2/0"})
  public void testDivideWithNotValidArguments(String input) throws IOException {
    assertEquals("Please use only positive numbers, and cannot divide by zero.", calculatorRunner.executeCalculation(input));
  }

}
