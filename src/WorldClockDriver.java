package com.devmountain.currentdate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class WorldClockDriver {

    public static void main(String[] args) {

        WorldClock worldClock = new WorldClock();


        DateTimeFormatter dateOnlyDTF = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        DateTimeFormatter dateTimeDTF = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");


        LocalDate nowLocalDate = worldClock.getNowForDate();
        System.out.println("nowLocalDate=" + dateOnlyDTF.format(nowLocalDate));

          LocalDateTime nowLocalDateTime = worldClock.getNowForDateAndTime();
         System.out.println("nowLocalDateTime=" + dateTimeDTF.format(nowLocalDateTime));
         System.out.println();

        /*
         * Now use the NOW date value to check the value of "DayOfWeek", e.g. is today a Friday?
         */
        System.out.println("nowLocalDate.getDayOfWeek()=" + worldClock.getDayOfWeekForNow());
        System.out.println("nowLocalDate.getDayOfMonth()=" + worldClock.getDayOfMonthForNow());
        System.out.println("nowLocalDate.getDayOfYear()=" + worldClock.getDayOfYearForNow());
        System.out.println();


      ZonedDateTime nowZonedDateTimeForNewYork = worldClock.getNowDateTimeForNewYork();
      System.out.println("nowZonedDateTimeForNewYork=" + dateTimeDTF.format(nowZonedDateTimeForNewYork));
      System.out.printf("nowZonedDateTimeForNewYork.getZone()=" + nowZonedDateTimeForNewYork.getZone());
      System.out.println();

       ZonedDateTime nowZonedDateTimeForLA = worldClock.getNowDateTimeForLA();
        System.out.printf("%n nowZonedDateTimeForLA=" + dateTimeDTF.format(nowZonedDateTimeForLA));
        System.out.printf("%n nowZonedDateTimeForLA.getZone()=" + nowZonedDateTimeForLA.getZone());
       System.out.println();

    ZonedDateTime nowZonedDateTimeForLondon = worldClock.getNowDateTimeForLondon();
      System.out.println("nowZonedDateTimeForLondon=" + dateTimeDTF.format(nowZonedDateTimeForLondon));

        System.out.println("nowZonedDateTimeForLondon.getZone()=" + nowZonedDateTimeForLondon.getZone());
        System.out.println();

        ZonedDateTime nowZonedDateTimeForMoscow = worldClock.getNowDateTimeForMoscow();
        System.out.println("nowZonedDateTimeForMoscow=" + dateTimeDTF.format(nowZonedDateTimeForMoscow));
        System.out.println("nowZonedDateTimeForMoscow.getZone()=" + nowZonedDateTimeForMoscow.getZone());
        System.out.println();
// ll
        ZonedDateTime nowZonedDateTimeForTokyo = worldClock.getNowDateTimeForTokyo();
        System.out.println("nowZonedDateTimeForTokyo=" + dateTimeDTF.format(nowZonedDateTimeForTokyo));
        System.out.println("nowZonedDateTimeForTokyo.getZone()=" + nowZonedDateTimeForTokyo.getZone());
    }
  }
