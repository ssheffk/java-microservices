import calculator.CalculatorRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculatorNotValidArguments {
  private CalculatorRunner calculatorRunner;
  @BeforeEach
  public void setUp(){
    calculatorRunner = new CalculatorRunner();
  }
  @ParameterizedTest
  @ValueSource(strings = {"", "2 ! 2"})
  public void testCalculatorWithNotValidArguments(String input) throws IOException {

    assertEquals("Program works with three arguments and operations: + - / *", calculatorRunner.executeCalculation(input));
  }

}
