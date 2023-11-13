import calculator.CalculatorRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculatorAdd {
  private CalculatorRunner calculatorRunner;
  @BeforeEach
  public void setUp() {
    calculatorRunner = new CalculatorRunner();
  }

  @Test
  public void testAddWithValidArguments() throws IOException {

    assertEquals("4.0", calculatorRunner.executeCalculation("2+2"));

  }


  @Test
  public void testAddWithNegativeArguments() throws IOException {

    assertEquals("Please use only positive numbers, and cannot divide by zero.", calculatorRunner.executeCalculation("-2+2"));
  }
}
