package cs3500.pa01;

import java.util.Comparator;

public class FileSortByModified implements Comparator<FileInformation>{
  @Override
  public int compare(FileInformation o1, FileInformation o2) {
    return o2.getDateModified().compareTo(o1.getDateModified());
  }
}