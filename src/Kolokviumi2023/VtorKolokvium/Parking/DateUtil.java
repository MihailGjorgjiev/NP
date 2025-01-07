package Kolokviumi2023.VtorKolokvium.Parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateUtil {
    public static long durationBetween(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end).toMinutes();
    }
}
