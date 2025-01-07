package Kolokviumi2023.VtorKolokvium.Parking;

import java.time.LocalDateTime;

public class ParkingEntry {
    private String registration;
    private String spot;
    private LocalDateTime timestampEntry;
    private LocalDateTime timestampLeave;
    private boolean entry;
    private int timesParked;

    public ParkingEntry(String registration, String spot, LocalDateTime timestamp) {
        this.registration = registration;
        this.spot = spot;
        this.timestampEntry = timestamp;
        this.entry = true;
        this.timesParked=1;
    }

    public void leave(LocalDateTime timestampLeave){
        this.timestampLeave=timestampLeave;
        this.entry=false;
    }
    public void reentry(LocalDateTime timestamp,String spot){
        this.timesParked++;
        this.spot=spot;
        this.timestampEntry=timestamp;
        this.entry=true;
        this.timestampLeave=null;
    }

    public LocalDateTime getTimestampLeave() {
        return timestampLeave;
    }

    public String getRegistration() {
        return registration;
    }

    public String getSpot() {
        return spot;
    }

    public LocalDateTime getTimestampEntry() {
        return timestampEntry;
    }

    public boolean isEntry() {
        return entry;
    }


    @Override
    public String toString() {
        String result=String.format("Registration number: %s Spot: %s Start timestamp: %s",registration,spot,timestampEntry);
        if(!entry){
            result+=String.format(" End timestamp: %s Duration in minutes: %d",timestampLeave,DateUtil.durationBetween(timestampEntry,timestampLeave));
        }

        return result;
    }

    public int getTimesParked() {
        return timesParked;
    }
}
