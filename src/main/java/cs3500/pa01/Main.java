package cs3500.pa01;

import java.io.IOException;
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

    Path path = Path.of(args[0]);
    OrderFlag orderingFlag = null;
    Path outputPath = Path.of(args[2]);

    if (args[1].equals("FILENAME") || args[1].equals("CREATED") || args[1].equals("MODIFIED")) {
      switch (args[1]) {
        case "FILENAME" -> orderingFlag = OrderFlag.FILENAME;
        case "CREATED" -> orderingFlag = OrderFlag.CREATED;
        case "MODIFIED" -> orderingFlag = OrderFlag.MODIFIED;
        default -> throw new IllegalStateException("Unexpected value: " + args[1]);
      }
    } else {
      throw new IllegalArgumentException("Order flag does not exist");
    }

    Driver.driver(path, orderingFlag, outputPath);
  }
}