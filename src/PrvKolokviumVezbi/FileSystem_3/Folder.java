package PrvKolokviumVezbi.FileSystem_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Folder implements IFile {

    private String fileName;
    private long fileSize;

    public List<IFile> getFiles() {
        return files;
    }

    private List<IFile> files;

    public Folder(String fileName) {
        this.fileName = fileName;
        this.fileSize = 0;
        this.files = new ArrayList<>();
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
        Collections.sort(files, new Comparator<IFile>() {
            @Override
            public int compare(IFile o1, IFile o2) {
                return (int) (o1.getFileSize() - o2.getFileSize());
            }
        });
        for (IFile file : files) {
            if (file instanceof Folder) {
                file.sortBySize();
            }
        }
    }

    @Override
    public String findLargestFile() {
        return "";
    }

    public long getLargestFile() {
        long maxSize = 0;
        IFile largestFile = null;
        for (IFile file : files) {
            if (maxSize < file.getFileSize()) {
                    maxSize=file.getFileSize();
                    largestFile=file;
            }
        }
        if(largestFile instanceof Folder){
            if(((Folder) largestFile).getFiles().size() != 0){
                return ((Folder) largestFile).getLargestFile();
            }
        }
        return largestFile.getFileSize();
//        return files.stream().map(IFile::getFileSize).max(new Comparator<Long>() {
//            @Override
//            public int compare(Long o1, Long o2) {
//                return (int) (o1 - o2);
//            }
//        }).orElse(0L);
    }

    void addFile(IFile file) throws FileNameExistsException {
        if (files.stream().anyMatch(f -> f.getFileName().equals(file.getFileName()))) {
            String error = String.format("There is already a file named %s in the folder %s", file.getFileName(), this.fileName);
            throw new FileNameExistsException(error);
        }

        this.files.add(file);
        this.fileSize += file.getFileSize();
    }

    @Override
    public String toString() {
        return folderIndentationToString(0);
    }
    private String  currentFolderToString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Folder name: %10s ",fileName));
        sb.append(String.format("Folder size: %10d",fileSize));
        sb.append('\n');

        return sb.toString();
    }

    private String folderIndentationToString(int indentLevel){
        StringBuilder sb= new StringBuilder();
        String indent="    ".repeat(indentLevel);

        sb.append(indent).append(currentFolderToString());

        for (IFile file : files) {
            if(file instanceof Folder){
                sb.append(((Folder) file).folderIndentationToString(indentLevel+1));
            }else{
                sb.append(indent).append("    ").append(file.toString());
            }

        }
        return sb.toString();


    }
}
