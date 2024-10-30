package PrvKolokvium.ArchiveStore_8;

import java.time.LocalDate;

public class SpecialArchive extends Archive{
    private int maxOpen;
    private int attemptsOpened;
    public SpecialArchive(int id, int maxOpen) {
        super(id, LocalDate.now());
        this.maxOpen=maxOpen;
        this.attemptsOpened=0;
    }

    public int getMaxOpen() {
        return maxOpen;
    }

    public void setMaxOpen(int maxOpen) {
        this.maxOpen = maxOpen;
    }
    public void openAttempt(){
        attemptsOpened++;
    }

    public int getAttemptsOpened() {
        return attemptsOpened;
    }
}
