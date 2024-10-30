package PrvKolokvium.ArchiveStore_8;

import java.time.LocalDate;

public class LockedArchive extends Archive{
    private LocalDate dateToOpen;

    public LockedArchive(int id,LocalDate dateToOpen) {
        super(id,LocalDate.now());
        this.dateToOpen = dateToOpen;
    }

    public LocalDate getDateToOpen() {
        return dateToOpen;
    }

    public void setDateToOpen(LocalDate dateToOpen) {
        this.dateToOpen = dateToOpen;
    }
}
