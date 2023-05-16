package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Tests the FileTreeWalkerVisitor class
 */
class FileTreeWalkerVisitorTest {
  String sampleinputsdirectory = "src/test/samplefiles";

  /**
   * Tests that the tree walker class walks through the class
   * and adds the md files to an array list of file information
   */
  @Test
  void getMdFiles() {
    FileTreeWalkerVisitor mfv = new FileTreeWalkerVisitor();

    try {
      Files.walkFileTree(Path.of(sampleinputsdirectory), mfv);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // build list of expected file paths
    ArrayList<FileInformation> expectedFiles = new ArrayList<>();

    Path pathForArraysMd = (Path.of(sampleinputsdirectory + "/arrays.md"));
    FileTime arraysMdCreationTime = FileTime.from(Instant.parse("2023-05-14T19:54:04Z"));
    FileTime arraysMdModificationTime =
        FileTime.from(Instant.parse("2023-05-14T19:54:33.112556888Z"));
    FileInformation arraysFile =
        new FileInformation(pathForArraysMd, "arrays.md", arraysMdModificationTime,
            arraysMdCreationTime);

    Path pathForVectorsMd = (Path.of(sampleinputsdirectory + "/vectors.md"));
    FileTime vectorsMdCreationTime = FileTime.from(Instant.parse("2023-05-14T19:54:38Z"));
    FileTime vectorsMdModificationTime =
        FileTime.from(Instant.parse("2023-05-14T19:55:22.481421607Z"));
    FileInformation vectorsFile =
        new FileInformation(pathForVectorsMd, "vectors.md", vectorsMdModificationTime,
            vectorsMdCreationTime);

    Path pathForFilesMd = (Path.of(sampleinputsdirectory + "/File/file.md"));
    FileTime fileMdCreationTime = FileTime.from(Instant.parse("2023-05-15T00:58:50Z"));
    FileTime fileMdModificationTime =
        FileTime.from(Instant.parse("2023-05-15T17:42:25.188519087Z"));
    FileInformation fileFile =
        new FileInformation(pathForFilesMd, "file.md", fileMdModificationTime,
            fileMdCreationTime);

    expectedFiles.add(fileFile);
    expectedFiles.add(arraysFile);
    expectedFiles.add(vectorsFile);

    // get list of traversed Markdown file paths
    ArrayList<FileInformation> actualFiles = mfv.getMdFiles();

    // compares content of index 0 in both lists
    assertEquals(actualFiles.get(0).getFilePath(),
        (Path.of(sampleinputsdirectory + "/File/file.md")));
    assertEquals(actualFiles.get(0).getFileName(), "file.md");
    assertEquals(actualFiles.get(0).getDateModified(), fileMdModificationTime);
    assertEquals(actualFiles.get(0).getDateCreated(), fileMdCreationTime);

    // compares content of index 1 in both lists
    assertEquals(actualFiles.get(1).getFilePath(),
        (Path.of(sampleinputsdirectory + "/arrays.md")));
    assertEquals(actualFiles.get(1).getFileName(), "arrays.md");
    assertEquals(actualFiles.get(1).getDateModified(), arraysMdModificationTime);
    assertEquals(actualFiles.get(1).getDateCreated(), arraysMdCreationTime);

    // compares content of index 2 in both lists
    assertEquals(actualFiles.get(2).getFilePath(),
        (Path.of(sampleinputsdirectory + "/vectors.md")));
    assertEquals(actualFiles.get(2).getFileName(), "vectors.md");
    assertEquals(actualFiles.get(2).getDateModified(), vectorsMdModificationTime);
    assertEquals(actualFiles.get(2).getDateCreated(), vectorsMdCreationTime);

    // compare both lists
    assertEquals(3, actualFiles.size());
  }
}