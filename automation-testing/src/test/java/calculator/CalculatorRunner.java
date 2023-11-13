package calculator;
import java.io.*;

import java.util.stream.Collectors;

public class CalculatorRunner {

  public String executeCalculation( String calculatorInput) throws IOException {


    Process process = new ProcessBuilder("java", "-jar", "calculator.jar", calculatorInput)
        .directory(new File("target/libs"))
        .redirectErrorStream(true)
        .start();

    InputStream stdout = process.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));


    return reader.lines().collect(Collectors.joining("\n"));
  }

}
