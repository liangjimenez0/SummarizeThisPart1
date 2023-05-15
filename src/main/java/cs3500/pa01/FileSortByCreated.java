package cs3500.pa01;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

public class FileSortByCreated implements Comparator<FileInformation>{
  @Override
  public int compare(FileInformation o1, FileInformation o2) {
    return o1.getDateCreated().compareTo(o2.getDateCreated());
  }
}
