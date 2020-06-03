package pl.marekGalganski.model;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

public class OpenWeatherMap {

    OWM owm;
    String apiKey;

    public OpenWeatherMap(String apiKey) {
        this.apiKey = apiKey;
        owm = new OWM(apiKey);
        owm.setUnit(OWM.Unit.METRIC);
    }

    public CurrentWeather getCurrentWeather(Integer cityId) throws APIException {
        return owm.currentWeatherByCityId(cityId);
    }

    public HourlyWeatherForecast getHourlyWeather(Integer cityId) throws APIException {
        return owm.hourlyWeatherForecastByCityId(cityId);
    }

}
