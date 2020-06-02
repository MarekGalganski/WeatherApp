package pl.marekGalganski.model.subsidiaryClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static String getHourMinute(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");

        return dateFormat.format(date);
    }

    public static String getDayMonthYear(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd-MM-yyyy");

        return dateFormat.format(date);
    }

    public static String getDayName(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE");

        return dateFormat.format(date);
    }
}
