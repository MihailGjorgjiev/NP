package CollectionBook.Generics.DataStructures.Collections.ArchiveStore;

import java.time.LocalDate;

public class LockedArchive extends Archive {
    private LocalDate dateToOpen;

    public LockedArchive(int id, LocalDate dateToOpen) {
        super(id);
        this.dateToOpen = dateToOpen;
    }

    public LocalDate getDateToOpen() {
        return dateToOpen;
    }

    public void setDateToOpen(LocalDate dateToOpen) {
        this.dateToOpen = dateToOpen;
    }


    @Override
    public void open(int id, LocalDate date) {
        if(date.isBefore(dateToOpen)){
            System.out.println(String.format("Item %d opened at %s",id,getDateArchived()));
        }else {
            System.out.println(String.format("Item %d cannot be opened before %s",id,dateToOpen));
        }
    }
}