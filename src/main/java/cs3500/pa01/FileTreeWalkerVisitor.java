package cs3500.pa01;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileTreeWalkerVisitor implements FileVisitor<Path> {

  private final ArrayList<FileInformation> fileList = new ArrayList<>();

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
    if (attr.isRegularFile()) {
      if (file.getFileName().toString().endsWith(".md")) {
        fileList.add(new FileInformation(file, file.getFileName().toString(), attr.lastModifiedTime(),
            attr.creationTime()));
      }
    }
    return CONTINUE;
  }

  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exec) {
    System.out.format("Finishing Director: %s%n", dir);
    return CONTINUE;
  }

  @Override
  public FileVisitResult preVisitDirectory(Path dir,
                                           BasicFileAttributes attrs) {
    System.out.format("Starting Directory: %s%n", dir);
    return CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    throwsError();
    return CONTINUE;
  }

  private void throwsError() {
    System.err.println("Visit file failed");
  }

  public ArrayList<FileInformation> getMdFiles() {
      return fileList;
  }
}

