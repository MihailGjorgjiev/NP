package PrvKolokviumVezbi.FileSystem_3;

public class File implements IFile{
    private String fileName;
    private long fileSize;

    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public Long getFileSize() {
        return fileSize;
    }

    @Override
    public String getFileInfo() {
        return "";
    }

    @Override
    public void sortBySize() {
        return;
    }

    @Override
    public String findLargestFile() {
        return "";
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("File name: %10s ",fileName));
        sb.append(String.format("File size: %10d",fileSize));
        sb.append('\n');

        return sb.toString();
    }
}
