package pl.marekGalganski.model.subsidiaryClasses;

import net.aksingh.owmjapis.model.param.WeatherData;

import java.util.Date;
import java.util.TimeZone;

public class WeatherDataService {

    private WeatherData weatherData;
    private TimeZone timeZone;

    public WeatherDataService(WeatherData weatherData, TimeZone timeZone) {
        this.weatherData = weatherData;
        this.timeZone = timeZone;
    }

    public String getTime() {
        Date date = weatherData.getDateTime();
        return DateFormatter.getHourMinute(date, timeZone) + "\n" + DateFormatter.getDayName(date, timeZone);
    }

    public Integer getTemperature() {
        return Formatter.getRoundedNumber(weatherData.getMainData().getTemp());
    }

    public String getIconCode() {
        return weatherData.getWeatherList().get(0).getIconCode();
    }

    public String getDay() {
        Date date = weatherData.getDateTime();
        return DateFormatter.getDayName(date, timeZone);
    }
}
