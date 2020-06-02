package pl.marekGalganski.model;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import pl.marekGalganski.model.subsidiaryClasses.DateFormatter;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class CurrentWeatherForecast {

    private CurrentWeather currentWeather;

    public CurrentWeatherForecast(OpenWeatherMap openWeatherMap, Integer cityId) throws APIException {
        this.currentWeather = openWeatherMap.getCurrentWeather(cityId);
    }

    public String getDate() {
        Date date = currentWeather.getDateTime();

        return DateFormatter.getDayMonthYear(date);
    }

    public String getCityName() {
        return currentWeather.getCityName();
    }

    public String getSunriseTime() {
        Date date = currentWeather.getSystemData().getSunriseDateTime();

        return DateFormatter.getHourMinute(date);
    }

    public String getSunsetTime() {
        Date date = currentWeather.getSystemData().getSunsetDateTime();

        return DateFormatter.getHourMinute(date);
    }


}
