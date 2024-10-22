package AV.AV3;

import java.util.Objects;
import java.util.stream.IntStream;

public class Date implements Comparable<Date>{
    @Override
    public int compareTo(Date o) {
        return this.days=o.days;
    }

    private static class InvalidDateException extends Exception {
        public InvalidDateException(String message) {
            super(message);
        }
    }

    private int days;

    public static final int START_YEAR;
    public static final int END_YEAR;
    public static final int DAYS_IN_YEAR;
    public static final int DAYS_IN_LEAP_YEAR;
    public static final int[] DAYS_IN_MONTH;
    public static final int[] DAYS_IN_LEAP_MONTH;
    public static final int MIN_DAYS;
    public static final int MAX_DAYS;

    static {
        START_YEAR = 1800;
        END_YEAR = 2500;
        DAYS_IN_YEAR = 365;
        DAYS_IN_LEAP_YEAR = 366;
        DAYS_IN_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        DAYS_IN_LEAP_MONTH = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        MIN_DAYS = 0;

        MAX_DAYS = IntStream.range(START_YEAR, END_YEAR + 1).map(year -> {
            if (isLeapYear(year)) {
                return DAYS_IN_LEAP_YEAR;
            } else {
                return DAYS_IN_YEAR;
            }
        }).sum()-1;
    }


    public Date(int days) throws InvalidDateException {
        if (days < MIN_DAYS || days > MAX_DAYS) {
            throw new InvalidDateException("Date is out od bounds");
        }
        this.days = days;
    }

    public Date(int date, int month, int year) throws InvalidDateException {
        int days=0;
        days+=IntStream.range(START_YEAR,year).map(y->{
            if(isLeapYear(y)) return DAYS_IN_LEAP_YEAR;
            else return DAYS_IN_YEAR;
        }).sum();

        if (isLeapYear(year)){
            days+=IntStream.range(1,month).map(i->DAYS_IN_LEAP_MONTH[i-1]).sum();
        }else{
            days+=IntStream.range(1,month).map(i->DAYS_IN_MONTH[i-1]).sum();
        }

        days+=(date-1);
        if (days < MIN_DAYS || days > MAX_DAYS) {
            throw new InvalidDateException("Date is out od bounds");
        }
        this.days=days;
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    @Override
    public String toString() {
        int d = days;
        int year, month;

        for (year = START_YEAR; year <= END_YEAR; year++) {
            if (isLeapYear(year)) {
                if (d < DAYS_IN_LEAP_YEAR) {
                    break;
                }
                d -= DAYS_IN_LEAP_YEAR;
            } else {
                if (d < DAYS_IN_YEAR) {
                    break;
                }
                d -= DAYS_IN_YEAR;
            }
        }
        month = 1;
        if (isLeapYear(year)) {
            for (int m : DAYS_IN_LEAP_MONTH) {
                if (d < m) {
                    break;
                }
                d -= m;
                month++;
            }
        }else {
            for (int m : DAYS_IN_MONTH) {
                if (d < m) {
                    break;
                }
                d -= m;
                month++;
            }
        }
        d++;
        return String.format("%02d-%02d-%04d", d, month, year);
    }

    public int substract(Date date) {
        return this.days-date.days;

    }
    public Date increment(int days) throws InvalidDateException {
        return new Date(this.days+days);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return days == date.days;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(days);
    }


    public static void main(String[] args) {
        try {

            Date sample = new Date(1, 10, 2012);
//            System.out.println(sample.substract(new Date(1, 1, 2000)));
            System.out.println(sample);
            sample = new Date(1, 1, 1800);
            System.out.println(sample);
            System.out.println(sample.days);
            System.out.println(sample.days);
            System.out.println();
            sample = new Date(31, 12, 2500);
            System.out.println(sample.days);
            System.out.println(sample);
            sample = new Date(30, 11, 2012);
            System.out.println(sample);
            sample = sample.increment(100);
            System.out.println(sample);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
