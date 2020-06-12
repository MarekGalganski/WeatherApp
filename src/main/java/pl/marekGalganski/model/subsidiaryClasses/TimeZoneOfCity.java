package pl.marekGalganski.model.subsidiaryClasses;

import com.github.bfsmith.geotimezone.TimeZoneLookup;
import com.github.bfsmith.geotimezone.TimeZoneResult;

import java.util.TimeZone;

public class TimeZoneOfCity {

    public TimeZone getTimeZoneOfTheCity(double latitude, double longitude) {

        if (isValidCoordinates(latitude, longitude)) {
            String timeZoneName = getStrTimeZoneOfTheCity(latitude, longitude);
            return TimeZone.getTimeZone(timeZoneName);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String getStrTimeZoneOfTheCity(double latitude, double longitude) {

        TimeZoneLookup timeZoneLookup = new TimeZoneLookup();
        TimeZoneResult timeZoneResult = timeZoneLookup.getTimeZone(latitude, longitude);
        return timeZoneResult.getResult();
    }

    private boolean isValidCoordinates(double latitude, double longitude) {

        if (MathMethods.isBetween(latitude, -90.00, 90.00) && MathMethods.isBetween(longitude, -180.00, 180.00)) {
            return true;
        } else {
            return false;
        }
    }
}
