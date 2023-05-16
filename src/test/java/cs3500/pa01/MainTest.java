package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;


/**
 * Tests the methods in the main class
 */
class MainTest {
  /**
   * Tests the main method for a created order flag
   *
   * @throws IOException Throws when an I/O error occurs
   */
  @Test
  void setUpCreated() throws IOException {
    String[] args1 = {"src/test/samplefiles", "CREATED", "src/test/samplefiles/study-guide"};

    Main.main(args1);
    assertTrue(Files.exists(Path.of("src/test/samplefiles/study-guide")));
  }

  /**
   * Tests the main method for a modified order flag
   *
   * @throws IOException Throws when an I/O error occurs
   */
  @Test
  void setUpModified() throws IOException {
    String[] args2 = {"src/test/samplefiles", "MODIFIED", "src/test/samplefiles/study-guide2"};

    Main.main(args2);
    assertTrue(Files.exists(Path.of("src/test/samplefiles/study-guide2")));
  }

  /**
   * Tests the main method for a file name order flag
   *
   * @throws IOException Throws when an I/O error occurs
   */
  @Test
  void setUpName() throws IOException {
    String[] args3 = {"src/test/samplefiles", "FILENAME", "src/test/samplefiles/study-guide"};

    Main.main(args3);
    assertTrue(Files.exists(Path.of("src/test/samplefiles/study-guide3")));
  }

  /**
   * Tests the main method when it does not properly set up
   */
  @Test
  void error() {
    String[] invalidArgs = {"not-a-path", "INVALID_FLAG", "not-a-path"};
    assertThrows(IllegalArgumentException.class, () -> Main.main(invalidArgs));
  }
}