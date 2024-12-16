package VtorKolokviumVezbi.Staduim_9;

import java.util.Arrays;

public class Sector {
    private String sectorCode;
    private int totalSeats;
    private int[] isSeatTaken;

    public String getSectorCode() {
        return sectorCode;
    }

    public Sector(String sectorCode, int totalSeats) {
        this.sectorCode = sectorCode;
        this.totalSeats = totalSeats;
        this.isSeatTaken = new int[totalSeats];
        for (int i = 0; i < isSeatTaken.length; i++) {
            isSeatTaken[i] = -1;
        }

    }

    public int getTotalFreeSeats() {
        return (int) Arrays.stream(isSeatTaken).filter(x -> x == -1).count();
    }

    public void bookSeat(int seat, int type) throws SeatTakenException, SeatNotAllowedException {
        if (isSeatTaken[seat - 1] != -1) {
            if ((isSeatTaken[seat - 1] == 1 && type == 2) || (isSeatTaken[seat - 1] == 2 && type == 1)) {
                throw new SeatNotAllowedException("SeatNotAllowedException");
            }
            throw new SeatTakenException("SeatTakenException");
        }
        isSeatTaken[seat - 1] = type;
    }

    @Override
    public String toString() {
        int totalFreeSeats = getTotalFreeSeats();
        double percentage = 100 * (1 - ((double) totalFreeSeats / totalSeats));
        return String.format("%s %d/%d %.1f%%", sectorCode, getTotalFreeSeats(), totalSeats, percentage);
    }
}
