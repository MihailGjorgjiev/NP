package PrvKolokvium.ArchiveStore_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchiveStore {
    private List<Archive> archives;
    private List<Integer> openings;

    public ArchiveStore() {
        this.archives = new ArrayList<>();
        this.openings = new ArrayList<>();
    }

    public List<Archive> getArchives() {
        return archives;
    }

    public void setArchives(List<Archive> archives) {
        this.archives = archives;
    }

    public void archiveItem(Archive item, LocalDate date) {
        item.setDateArchived(date);
        archives.add(item);
    }

    public void openItem(int id, LocalDate date) throws NonExistingItemException {
        Archive existingArchive = archives.stream().filter(a -> a.getId() == id && a.getDateArchived().equals(date)).findFirst().orElse(null);
        if (existingArchive == null) {
            throw new NonExistingItemException(
                    String.format("Item with id %d doesn't exist", id));
        } else {
//            if (existingArchive instanceof SpecialArchive) {
//                ((SpecialArchive) existingArchive).openAttempt();
//            }
            openings.add(id);
        }
    }

    public String getLog() {
        String output = "";
        for (Archive archive : archives) {
            output += String.format("Item %d archived at %s\n", archive.getId(), archive.getDateArchived().toString());
        }
        for (Integer id : openings) {
            Archive archive = archives.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
            if (archive instanceof SpecialArchive) {
                SpecialArchive specialArchive = (SpecialArchive) archive;
                specialArchive.openAttempt();
                if (specialArchive.getAttemptsOpened() <= specialArchive.getMaxOpen()) {
                    output += String.format("Item %d opened at %s\n", specialArchive.getId(), specialArchive.getDateArchived());
                } else {
                    output += String.format("Item %d cannot be opened more than %d times\n", specialArchive.getId(), specialArchive.getMaxOpen());
                }
            }
            if (archive instanceof LockedArchive) {
                LockedArchive lockedArchive = (LockedArchive) archive;
                if (lockedArchive.getDateToOpen().isAfter(lockedArchive.getDateArchived())) {
                    output += String.format("Item %d cannot be opened before %s\n", lockedArchive.getId(), lockedArchive.getDateToOpen());
                } else {
                    output += String.format("Item %d opened at %s\n", lockedArchive.getId(), lockedArchive.getDateArchived());
                }

            }
        }
//        for (Archive archive : archives) {
//            if (archive instanceof LockedArchive) {
//                LockedArchive lockedArchive = (LockedArchive) archive;
//                if (lockedArchive.getDateToOpen().isAfter(LocalDate.now())) {
//                    output += String.format("Item %d cannot be opened before %s", lockedArchive.getId(), lockedArchive.getDateToOpen());
//                } else {
//                    output += String.format("Item %d opened at %s", lockedArchive.getId(), lockedArchive.getDateToOpen());
//                }
//            }
//            if (archive instanceof SpecialArchive) {
//                SpecialArchive specialArchive = (SpecialArchive) archive;
//                if
//            }
//        }
        return output;
    }
}
