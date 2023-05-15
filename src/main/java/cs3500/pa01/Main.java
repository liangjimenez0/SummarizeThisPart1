package cs3500.pa01;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class Main {
  public static void main(String[] args) throws IOException {

    Path path = null;

    try {
      path = Path.of(args[0]);
    } catch (InvalidPathException e) {
      System.err.println("Cannot assign path");
    }

    OrderFlag orderingFlag = null;
    Path outputPath = null;

    switch (args[1]) {
      case "FILENAME" -> orderingFlag = OrderFlag.FILENAME;
      case "CREATED" -> orderingFlag = OrderFlag.CREATED;
      case "MODIFIED" -> orderingFlag = OrderFlag.MODIFIED;
    }

    try {
      outputPath = Path.of(args[2]);
    } catch (InvalidPathException e) {
      System.err.println("Cannot assign path");
    }

    if (orderingFlag != null) {
      Driver.driver(path, orderingFlag, outputPath);
    }
  }
}