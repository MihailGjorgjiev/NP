package PrvKolokvium.FileSystem_3;

public class FileNameExistsException extends Exception {
    public FileNameExistsException(String fileName) {
        super(fileName);
    }
}
