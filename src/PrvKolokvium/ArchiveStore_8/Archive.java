package PrvKolokvium.ArchiveStore_8;

import java.time.LocalDate;

public class Archive {
    private int id;
    private LocalDate dateArchived;


    public Archive(int id, LocalDate dateArchived) {
        this.id = id;
        this.dateArchived = dateArchived;

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
}
