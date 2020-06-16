package pl.marekGalganski.model.subsidiaryClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatter {

    public static String getHourMinute(Date date, TimeZone timeZone) {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        formatter.setTimeZone(timeZone);
        return formatter.format(date);
    }


    public static String getDayMonthYear(Date date, TimeZone timeZone) {
        DateFormat formatter = new SimpleDateFormat("EEEE, d MMMM yyyy", Locale.ENGLISH);

        formatter.setTimeZone(timeZone);
        return formatter.format(date);
    }

    public static String getDayName(Date date, TimeZone timeZone) {
        DateFormat formatter = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        formatter.setTimeZone(timeZone);

        return formatter.format(date);
    }

    public static Long getCurrentDate() {

        return new Date().getTime();
    }
}
