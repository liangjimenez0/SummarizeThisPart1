package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileCompiler {
  StringBuilder builder = new StringBuilder();
  public void compile(ArrayList<FileInformation> mdFiles) {

    ArrayList<Path> pathList = new ArrayList<>();
    Scanner input = null;

    for (FileInformation p : mdFiles) {
      pathList.add(p.getFilePath());
    }

    for (Path p : pathList) {
      try {
        input = new Scanner(p);
      } catch (IOException e) {
        System.exit(1);
      }

      while (input.hasNext()) {
        builder.append(input.nextLine()).append(System.lineSeparator());
      }
    }
  }
  public String getCompiled() {
    return builder.toString();
  }
}
