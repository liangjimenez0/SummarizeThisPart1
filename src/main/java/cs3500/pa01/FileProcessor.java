package cs3500.pa01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessor {
  public void processFiles(String compiledFile, Path mdFile) throws IOException {
    Scanner input = null;
    File studyGuide = new File(mdFile.toString());
    BufferedWriter writer = null;

    try {
      input = new Scanner(compiledFile);
      writer = new BufferedWriter(new FileWriter(studyGuide));
      Pattern pattern = Pattern.compile("\\[\\[(.*?)\\]\\]");
//      Matcher matcher = pattern.matcher(compiledFile);

      while (input.hasNextLine()) {
        String line = input.nextLine();
        Matcher matcher = pattern.matcher(line);

        if (line.startsWith("#")) {
          writer.newLine();
          writer.write(line + System.lineSeparator());
        } else if (matcher.find()) {
          writer.write("- " + matcher.group(1) + System.lineSeparator());
        }
      }

      input.close();
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
