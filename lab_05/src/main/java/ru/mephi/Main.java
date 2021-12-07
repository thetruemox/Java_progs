package ru.mephi;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.DayOfWeek.*;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        LocalDate now, bDate, dDate;
        now = LocalDate.now();
/*
        out.println("Abe Lincoln");
        bDate = LocalDate.of(1809, 2, 12);
        dDate = LocalDate.of(1855, 4, 15);
        out.println(bDate.until(dDate).getYears());
        out.println((bDate.datesUntil(dDate)).count());

        out.println("\nBennedict Cumberbatch");
        bDate = LocalDate.of(1976, 7, 19);
        out.println(bDate.isLeapYear());
        out.println(bDate.lengthOfYear());
        out.println(ChronoUnit.DECADES.between(bDate, now));
        bDate = bDate.plusYears(21);
        out.println(bDate.getDayOfWeek());
*/
        out.println("\nTrain: Boston to New York");
        LocalTime tr_dep = LocalTime.of(1,45);
        LocalTime tr_arr = LocalTime.of(7,25);
        LocalTime tr_ride = tr_arr.minusHours(tr_dep.getHour()).minusMinutes(tr_dep.getMinute());
        out.println(tr_ride);
        out.println(tr_dep.plusHours(tr_ride.getHour() + 1).plusMinutes(tr_ride.getMinute() + 19));
/*
        out.println("\nFlight: Boston to Miami");
        LocalDateTime start;
        LocalTime flight;
        start = LocalDate.of(2021, Month.MARCH, 24).atTime(21, 15);
        flight = LocalTime.of(4,15);
        out.println(start.plusHours(flight.getHour()).plusMinutes(flight.getMinute()));
        LocalTime delay = LocalTime.of(4, 27);
        out.println(start.plusHours(flight.getHour() + delay.getHour()).plusMinutes(flight.getMinute() + delay.getMinute()));

        out.println("\nSchool semester");
        LocalDate semStarts = LocalDate.of(2021, Month.SEPTEMBER, 1);
        TemporalAdjuster secondTuesday = TemporalAdjusters.dayOfWeekInMonth(2, TUESDAY);
        out.println(semStarts.with(secondTuesday));
        LocalDate semEnds = LocalDate.of(2022, Month.JUNE, 25);
        long allDays = ChronoUnit.DAYS.between(semStarts.with(secondTuesday), semEnds);
        allDays /= 7;
        allDays *= 5;
        allDays -= 20;
        out.println(allDays);

        out.println("\nFlight 123, San Francisco to  Boston");
        start = LocalDate.of(2014, Month.JUNE, 13).atTime(22, 30);
        flight = LocalTime.of(5, 30);
        ZonedDateTime sanFrancTime = ZonedDateTime.of(start, ZoneId.of("America/Los_Angeles"));
        out.println(sanFrancTime.withZoneSameInstant(ZoneId.of("America/New_York")));
        ZonedDateTime arrival = ZonedDateTime.of(start.plusHours(flight.getHour()).plusMinutes(flight.getMinute()), ZoneId.of("America/Los_Angeles"));
        out.println(arrival.withZoneSameInstant(ZoneId.of("America/New_York")));
        out.println(arrival);

        out.println("\nFlight 456, San Francisco to Bangalore");
        start = LocalDate.of(2014, Month.JUNE, 28).atTime(22,30);
        flight = LocalTime.of(22,0);
        sanFrancTime = ZonedDateTime.of(start, ZoneId.of("America/Los_Angeles"));
        arrival = (ZonedDateTime.of(start.plusHours(flight.getHour()).plusMinutes(flight.getMinute()), ZoneId.of("America/Los_Angeles"))).withZoneSameInstant(ZoneId.of("Asia/Calcutta"));
        ZonedDateTime meeting = ZonedDateTime.of(LocalDate.of(2014, Month.JUNE, 29).atTime(9,0), ZoneId.of("Asia/Calcutta"));
        out.println(arrival.isBefore(meeting));
        out.println(ZonedDateTime.of(start.plusHours(flight.getHour()).plusMinutes(flight.getMinute()), ZoneId.of("America/Los_Angeles")) + " idk is it reasonable time or not");

        out.println("\nFlight 123, San Francisco to Boston");
        start = LocalDate.of(2014, Month.NOVEMBER, 1).atTime(22,30);
        flight = LocalTime.of(5, 30);
        sanFrancTime = ZonedDateTime.of(start, ZoneId.of("America/Los_Angeles"));
        arrival = ZonedDateTime.of(start.plusHours(flight.getHour()).plusMinutes(flight.getMinute()), ZoneId.of("America/Los_Angeles"));
        out.println(arrival.withZoneSameInstant(ZoneId.of("America/New_York")));
 */
    }
}
