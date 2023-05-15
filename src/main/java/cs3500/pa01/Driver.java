package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This is the main driver of this project.
 */
public class Driver {

  public static void driver(Path path, OrderFlag orderingFlag, Path outputPath) throws IOException {

    FileTreeWalkerVisitor reader = new FileTreeWalkerVisitor();
    Files.walkFileTree(path, reader);

    if (orderingFlag.equals(OrderFlag.FILENAME)) {
      reader.getMdFiles().sort(new FileSortByName());
    } else if (orderingFlag.equals(OrderFlag.CREATED)) {
      reader.getMdFiles().sort(new FileSortByCreated());
    } else {
      reader.getMdFiles().sort(new FileSortByModified());
    }

    FileCompiler compiler = new FileCompiler();
    compiler.compile(reader.getMdFiles());

    FileProcessor processor = new FileProcessor();
    processor.processFiles(compiler.getCompiled(), outputPath);
  }
}
