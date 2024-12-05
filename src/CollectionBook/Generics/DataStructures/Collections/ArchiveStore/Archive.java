package CollectionBook.Generics.DataStructures.Collections.ArchiveStore;

import java.time.LocalDate;

public class Archive {
    private int id;
    private LocalDate dateArchived;

    public Archive(int id) {
        this.id = id;
        this.dateArchived=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateArchived() {
        return dateArchived;
    }

    public void setDateArchived(LocalDate dateArchived) {
        this.dateArchived = dateArchived;
    }

    public void open(int id,LocalDate date){

    }
}