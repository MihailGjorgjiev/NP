package CollectionBook.Generics.DataStructures.Collections.ArchiveStore;

import java.time.LocalDate;

public class SpecialArchive extends Archive{
    private int maxOpen;
    private int attemptsLeft;
    public SpecialArchive(int id,int maxOpen) {
        super(id);
        this.maxOpen=maxOpen;
        this.attemptsLeft=maxOpen;
    }

    public int getMaxOpen() {
        return maxOpen;
    }

    public void setMaxOpen(int maxOpen) {
        this.maxOpen = maxOpen;
    }

    @Override
    public void open(int id, LocalDate date) {
        if(attemptsLeft>0){
            System.out.println(String.format("Item %d opened at %s",id,getDateArchived()));
        }else {
            System.out.println(String.format("Item %d cannot be opened more than %d times",id,maxOpen));
        }
    }
}