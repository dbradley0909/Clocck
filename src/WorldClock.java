
package com.devmountain.currentdate;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class WorldClock {
    // ll
    public LocalDate getNowForDate() {
//  this will work with DateTimeFormatter dtf on the world clock driver line 16
        LocalDate gd = LocalDate.now();
        return gd;

    }

    public LocalDateTime getNowForDateAndTime() {
//  this will work with DateTimeFormatter dtf on the world clock driver line 17
        LocalDateTime gdat  = LocalDateTime.now();
        return gdat;
    }

    public DayOfWeek getDayOfWeekForNow() {

        LocalDateTime gdaw = LocalDateTime.now();
        return gdaw.getDayOfWeek();
    }

    public int getDayOfMonthForNow() {
        LocalDateTime gdom = LocalDateTime.now();
        return gdom.getDayOfMonth();
    }

    public int getDayOfYearForNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.getDayOfYear();
    }

    public ZonedDateTime getNowDateTimeForNewYork() {
        return getNowDatetimeWithZoneId("America/New_York");
    }

    public ZonedDateTime getNowDateTimeForLA() {
        return getNowDatetimeWithZoneId("America/Los_Angeles");
    }

    public ZonedDateTime getNowDateTimeForLondon() {
        return getNowDatetimeWithZoneId("Europe/London");
    }

    public ZonedDateTime getNowDateTimeForMoscow() {
        return getNowDatetimeWithZoneId("Europe/Moscow");
    }

    public ZonedDateTime getNowDateTimeForTokyo() {
        return getNowDatetimeWithZoneId("Asia/Tokyo");
    }

    private ZonedDateTime getNowDatetimeWithZoneId(String zoneId) {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime zonedDateTime = now.withZoneSameInstant(ZoneId.of(zoneId));
        return zonedDateTime;
    }


}
