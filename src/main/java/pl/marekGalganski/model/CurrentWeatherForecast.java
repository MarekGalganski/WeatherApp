package pl.marekGalganski.model;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import pl.marekGalganski.model.subsidiaryClasses.DateFormatter;
import pl.marekGalganski.model.subsidiaryClasses.Formatter;
import pl.marekGalganski.model.subsidiaryClasses.GlyphNames;

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

    public String getTemperature() {
        double temp = currentWeather.getMainData().getTemp();

        return Formatter.getRoundedNumber(temp) + "°C";
    }

    public String getWind() {
        double wind = currentWeather.getWindData().getSpeed();

        return Formatter.changeMPerStoKmPerH(wind) + "km/h";
    }

    public String getWeatherDescription() {
        String description = currentWeather.getWeatherList().get(0).getMoreInfo();

        return description;
    }

    public String getHumidity() {
        double humidity = currentWeather.getMainData().getHumidity();

        return Formatter.getRoundedNumber(humidity) + "%";
    }

    public String getPressure() {
        double pressure = currentWeather.getMainData().getPressure();

        return Formatter.getRoundedNumber(pressure) + "hpa";
    }

    public String getCurrentWeatherIconCode() {
        return currentWeather.getWeatherList().get(0).getIconCode();
    }

    public String getCurrentWeatherGlyphName() {
        return GlyphNames.getGlyphName(getCurrentWeatherIconCode());
    }


}
