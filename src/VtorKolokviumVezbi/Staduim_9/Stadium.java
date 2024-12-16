package VtorKolokviumVezbi.Staduim_9;

import java.util.*;

public class Stadium {
    private String name;
    private Map<String, Sector> sectors;

    public Stadium(String name) {
        this.name = name;
        this.sectors = new HashMap<>();
    }

    public void createSectors(String[] sectorNames, int[] sizes) {
        for (int i = 0; i < sectorNames.length; i++) {
            String sectorName = sectorNames[i];
            int size = sizes[i];
            sectors.put(sectorName, new Sector(sectorName, size));
        }
    }

    public void buyTicket(String sectorName, int seat, int type) throws SeatTakenException, SeatNotAllowedException {
        sectors.get(sectorName).bookSeat(seat, type);
    }

    public void showSectors() {
        sectors.values().stream()
                .sorted(Comparator.comparing(Sector::getTotalFreeSeats, Comparator.reverseOrder())
                        .thenComparing(Sector::getSectorCode))
                .forEach(System.out::println);
    }


}
