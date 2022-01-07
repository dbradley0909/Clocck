//package com.devmountain.parse;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalendarHelper {

    private DateTimeFormatter formatter;
    private LocalDate birthdayLocalDate;
    private LocalDate nowLocalDate;
    private int currentYear;
    private List<LocalDate> holidayList;

    public CalendarHelper(String birthdayString) {
        formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        //convert String to LocalDate
        birthdayLocalDate = LocalDate.parse(birthdayString, formatter);
        nowLocalDate = LocalDate.now();
        currentYear = nowLocalDate.getYear();

        holidayList = initHolidayList(currentYear, nowLocalDate);
    }

    public void displayDaysRemainingToHolidaysAndBirthday() {

        System.out.println("The current date is: " + formatter.format(nowLocalDate));
        int dayOfYearForNow = nowLocalDate.getDayOfYear();
        int remainingDay = 0;
        int smallestRemainingDays = 1000;
        LocalDate closestHoliday = null;
        for (LocalDate eachHoliday : holidayList) {
            int dayOfYearHoliday = eachHoliday.getDayOfYear();
            if (dayOfYearForNow <= dayOfYearHoliday) {
                remainingDay = dayOfYearHoliday - dayOfYearForNow;
                if (isRemainingDaySmallest(smallestRemainingDays, remainingDay)) {
                    smallestRemainingDays = remainingDay;
                    closestHoliday = eachHoliday;
                    System.out.println();
                }

                System.out.println("There are " + remainingDay + " days remaining before Holiday (" + formatter.format(eachHoliday) + ")");
            } else {
                remainingDay = 365 - dayOfYearForNow + dayOfYearHoliday;
                if (isRemainingDaySmallest(smallestRemainingDays, remainingDay)) {
                    smallestRemainingDays = remainingDay;
                    closestHoliday = eachHoliday;
                    System.out.println();
                }

                System.out.println("There are " + remainingDay + " days remaining before Holiday (" + formatter.format(eachHoliday) + ")");
            }
        }

        System.out.println("the closest Holiday to the current date (" + formatter.format(nowLocalDate) + ") is: " + formatter.format(closestHoliday));


        int dayOfYearForBirthday = birthdayLocalDate.getDayOfYear();
        int age = nowLocalDate.getYear() - birthdayLocalDate.getYear();
        LocalDate nextBirthdayLocalDate = birthdayLocalDate.withYear(nowLocalDate.getYear());
        if (dayOfYearForNow <= dayOfYearForBirthday) {
            remainingDay = dayOfYearForBirthday - dayOfYearForNow;
        } else {
            remainingDay = dayOfYearForBirthday + 365 - dayOfYearForNow;
            age++;
            nextBirthdayLocalDate = birthdayLocalDate.withYear(nowLocalDate.getYear() + 1);
        }

        System.out.println("There are " + remainingDay + " days remaining before your " + age + "th birthday (" + formatter.format(nextBirthdayLocalDate) + ")");
    }

    private boolean isRemainingDaySmallest(int smallestRemainingDay, int remainingDay) {
        boolean isSmallest = false;
        if(remainingDay < smallestRemainingDay)
            isSmallest = true;
        return isSmallest;
    }

    private List<LocalDate> initHolidayList(int currentYear, LocalDate nowLocalDate) {
        List<LocalDate> holidayList = new ArrayList<>(5);
        int nextYear = currentYear + 1;

        LocalDate julyFourth = LocalDate.of(currentYear, Month.JULY, 4);
        if(nowLocalDate.isAfter(julyFourth))
            julyFourth = LocalDate.of(nextYear, Month.JULY, 4);
        holidayList.add(julyFourth);


        LocalDate newYear = LocalDate.of(currentYear, Month.JANUARY, 1);
        if(nowLocalDate.isAfter(newYear))
            newYear = LocalDate.of(nextYear, Month.JANUARY, 1);
        holidayList.add(newYear);


        LocalDate christmas = LocalDate.of(currentYear, Month.DECEMBER, 25);
        if(nowLocalDate.isAfter(christmas))
            christmas = LocalDate.of(nextYear, Month.DECEMBER, 25);
        holidayList.add(christmas);

        return holidayList;
    }


}
