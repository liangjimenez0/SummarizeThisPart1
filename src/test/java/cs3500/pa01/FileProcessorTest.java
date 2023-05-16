package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the methods in the FileProcessor class
 */
class FileProcessorTest {

  String file1;
  FileProcessor processor;
  Path mdFile1;
  String file2;
  String file3;
  Scanner input;
  StringBuilder builder;

  /**
   * Sets up the variables for testing
   */
  @BeforeEach
  void setup() {
    file1 = "";
    processor = new FileProcessor();
    mdFile1 = Path.of("files.md");

    file2 = """
        # Java Arrays
        - [[An **array** is a collection of variables of the same type]], referred to\s
        by a common name.\s
        - In Java, arrays are objects, and must be created dynamically (at runtime).""";
    file3 = "Hello my name is Liang";

    input = null;
    builder = new StringBuilder();
    try {
      input = new Scanner(mdFile1);
    } catch (IOException e) {
      System.exit(1);
    }
  }

  /**
   * Tests method process to see if all the content from
   * the files is in one string
   */
  @Test
  void processFiles1() {
    processor.processFiles(file1, mdFile1);

    while (input.hasNext()) {
      builder.append(input.nextLine()).append(System.lineSeparator());
    }
    assertEquals(file1, builder.toString());

  }

  /**
   * Tests method process to see if all the content from
   * the files is in one string
   */
  @Test
  void processFiles2() {

    processor.processFiles(file2, mdFile1);

    while (input.hasNext()) {
      builder.append(input.nextLine()).append(System.lineSeparator());
    }

    assertEquals("""
        # Java Arrays
        - An **array** is a collection of variables of the same type
        """, builder.toString());
  }

  /**
   * Tests method process to see if all the content from
   * the files is in one string
   */
  @Test
  void processFiles3() {

    processor.processFiles(file3, mdFile1);

    while (input.hasNext()) {
      builder.append(input.nextLine()).append(System.lineSeparator());
    }

    assertEquals("", builder.toString());
  }
}