package VtorKolokviumVezbi.Staduim_9;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Sector {
    private String sectorCode;
    private int totalSeats;
    private boolean[] isSeatTaken;
    private int type;

    public String getSectorCode() {
        return sectorCode;
    }

    public Sector(String sectorCode, int totalSeats) {
        this.sectorCode = sectorCode;
        this.totalSeats = totalSeats;
        this.isSeatTaken = new boolean[totalSeats];
        for (int i = 0; i < isSeatTaken.length; i++) {
            isSeatTaken[i] = false;
        }
        this.type=0;
    }

    public int getTotalFreeSeats() {
        return (int) IntStream.range(0,totalSeats)
                .filter(i->!isSeatTaken[i])
                .count();
    }

    public void bookSeat(int seat, int type) throws SeatTakenException, SeatNotAllowedException {
        if(this.type == 0 && type != 0){
            this.type=type;
        }
        if(this.isSeatTaken[seat-1]){
            throw new SeatTakenException("SeatTakenException");
        }
        if((this.type == 1 && type == 2) || (this.type == 2 && type == 1)){
            throw new SeatNotAllowedException("SeatNotAllowedException");
        }
        isSeatTaken[seat-1]=true;
    }

    @Override
    public String toString() {
        int totalFreeSeats = getTotalFreeSeats();
        double percentage = 100 * (1 - ((double) totalFreeSeats / totalSeats));
        return String.format("%s\t%d/%d\t%.1f%%", sectorCode, getTotalFreeSeats(), totalSeats, percentage);
    }
}
