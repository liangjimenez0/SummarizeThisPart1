package cs3500.pa01;

import java.util.Comparator;

public class FileSortByName implements Comparator<FileInformation>{
  @Override
  public int compare(FileInformation o1, FileInformation o2) {
    return o1.getFileName().compareTo(o2.getFileName());
  }
}
