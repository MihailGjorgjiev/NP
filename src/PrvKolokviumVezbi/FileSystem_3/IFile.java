package PrvKolokviumVezbi.FileSystem_3;

public interface IFile {
    String getFileName();

    Long getFileSize();

    String getFileInfo();

    void sortBySize();

    String findLargestFile();
}
