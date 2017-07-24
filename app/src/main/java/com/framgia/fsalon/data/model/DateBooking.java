package com.framgia.fsalon.data.model;

/**
 * Created by MyPC on 20/07/2017.
 */
public class DateBooking {
    private String mDay;
    private String mDayOfWeek;
    private String mDateTime;

    public DateBooking(String day, String dayOfWeek, String dateTime) {
        mDay = day;
        mDayOfWeek = dayOfWeek;
        mDateTime = dateTime;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        mDay = day;
    }

    public String getDayOfWeek() {
        return mDayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        mDayOfWeek = dayOfWeek;
    }

    public String getDateTime() {
        return mDateTime;
    }

    public void setDateTime(String dateTime) {
        mDateTime = dateTime;
    }
}
