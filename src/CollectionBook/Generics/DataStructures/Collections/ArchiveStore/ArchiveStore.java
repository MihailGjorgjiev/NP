package CollectionBook.Generics.DataStructures.Collections.ArchiveStore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ArchiveStore {
    private List<Archive> archives;

    public ArchiveStore() {
        this.archives=new ArrayList<>();
    }

    public void archiveItem(Archive archive, LocalDate date){
        archive.setDateArchived(date);
        System.out.println("Item "+archive.getId()+" archived at "+date);
        archives.add(archive);
    }

    public void openItem(int id,LocalDate date) throws NonExistingItemException {
        int i;
        for(i=0;i<archives.size();i++){
            if(archives.get(i).getId()==id){
                break;
            }
        }
        if(i==archives.size()){
            throw new NonExistingItemException("tem with id "+id+" doesn’t exist");
        }

    }
}