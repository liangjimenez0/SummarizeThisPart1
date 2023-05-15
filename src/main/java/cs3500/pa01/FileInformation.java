package cs3500.pa01;

import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class FileInformation {
  Path filePath;
  String fileName;
  FileTime dateModified;
  FileTime dateCreated;

  FileInformation(Path filePath, String fileName, FileTime dateModified, FileTime dateCreated) {
    this.filePath = filePath;
    this.fileName = fileName;
    this.dateModified = dateModified;
    this.dateCreated = dateCreated;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FileInformation that)) { return false; }

    return this.filePath.equals(that.filePath)
        && this.fileName.equals(that.fileName)
        && this.dateModified.equals(that.dateModified)
        && this.dateCreated.equals(that.dateCreated);

  }

  Path getFilePath() {
    return filePath;
  }

  String getFileName() {
    return fileName;
  }

  FileTime getDateModified() {
    return dateModified;
  }

  FileTime getDateCreated() {
    return dateCreated;
  }

}
