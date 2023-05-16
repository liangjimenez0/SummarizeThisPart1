package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Used to test the methods in Driver
 */
class DriverTest {

  Path outputPath1;
  Path outputPath2;
  Path outputPath3;
  Path directory;

  /**
   * Sets up the variables used in testing
   */
  @BeforeEach
  void setup() {
    outputPath1 = Path.of("src/test/samplefiles/study-guide");
    outputPath2 = Path.of("src/test/samplefiles/study-guide2");
    outputPath3 = Path.of("src/test/samplefiles/study-guide3");
    directory = Path.of("src/test/samplefiles");
  }

  /**
   * Tests the driver method on a date created order flag
   */
  @Test
  void driverCreated() {
    try {
      Driver.driver(directory, OrderFlag.CREATED,
          outputPath1);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    assertTrue(Files.exists(outputPath1));
  }

  /**
   * Tests the driver method on a date modified order flag
   */
  @Test
  void driverModified() {

    try {
      Driver.driver(directory, OrderFlag.MODIFIED,
          outputPath2);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    assertTrue(Files.exists(outputPath2));
  }

  /**
   * Tests the driver method on a file name order flag
   */
  @Test
  void driverName() {
    try {
      Driver.driver(directory, OrderFlag.FILENAME,
          outputPath3);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    assertTrue(Files.exists(outputPath3));
  }
}
