package cs3500.pa01;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

/**
 * Represents the main class which takes in the arguments from the user
 */
public class Main {
  /**
   * Takes in a users' arguments and converts them to File Paths and Ordering Flags.
   * Delegates these arguments to the Driver class.
   *
   * @param args Arguments from the user that represent path, orderingFlag, and outputPath
   * @throws IOException Throws when an I/O error occurs
   */
  public static void main(String[] args) throws IOException {

    Path path;

    try {
      path = Path.of(args[0]);
    } catch (InvalidPathException e) {
      throw new IllegalArgumentException();
    }

    OrderFlag orderingFlag;
    Path outputPath;

    switch (args[1]) {
      case "FILENAME" -> orderingFlag = OrderFlag.FILENAME;
      case "CREATED" -> orderingFlag = OrderFlag.CREATED;
      case "MODIFIED" -> orderingFlag = OrderFlag.MODIFIED;
      default -> throw new IllegalArgumentException();
    }

    try {
      outputPath = Path.of(args[2]);
    } catch (InvalidPathException e) {
      throw new IllegalArgumentException();
    }

    Driver.driver(path, orderingFlag, outputPath);
  }
}