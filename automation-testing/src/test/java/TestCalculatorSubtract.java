import calculator.CalculatorRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculatorSubtract {
  private CalculatorRunner calculatorRunner;
  @BeforeEach
  public void setUp()  {
    calculatorRunner = new CalculatorRunner();
  }
  @Test
  public void testSubtractWithValidArguments() throws IOException {

    assertEquals("0.0", calculatorRunner.executeCalculation("2 - 2"));

  }

  @Test
  public void testSubtractWithNegativeArguments() throws IOException {

    assertEquals("Please use only positive numbers, and cannot divide by zero.", calculatorRunner.executeCalculation("-2-2"));
  }
}
