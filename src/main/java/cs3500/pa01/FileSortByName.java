package cs3500.pa01;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileSortByName implements Comparator<FileInformation>{
  @Override
  public int compare(FileInformation o1, FileInformation o2) {
    return o1.getFileName().compareTo(o2.getFileName());
  }
}
