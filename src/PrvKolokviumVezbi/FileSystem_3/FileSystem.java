package PrvKolokviumVezbi.FileSystem_3;

public class FileSystem {
    private Folder rootDirectory;

    @Override
    public String toString() {
        return rootDirectory.toString();
    }

    public FileSystem() {
        rootDirectory = new Folder("root");
    }

    void addFile(IFile file) throws FileNameExistsException {
        rootDirectory.addFile(file);
    }

    public long findLargestFile() {
        return rootDirectory.getLargestFile();
    }
    void sortBySize(){
        rootDirectory.sortBySize();
    }
}
