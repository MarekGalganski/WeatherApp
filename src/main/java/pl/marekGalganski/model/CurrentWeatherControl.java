package pl.marekGalganski.model;


import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;

public class CurrentWeatherControl {

    private VBox vBox;
    private Label dateLabel;
    private Label cityNameLabel;
    private Label sunriseTimeLabel;
    private Label sunsetTimeLabel;
    private Label temperatureLabel;
    private Label weatherDescriptionLabel;
    private Label windLabel;
    private Label humidityLabel;
    private Label pressureLabel;
    private WeatherIconView weatherIcon;

    public CurrentWeatherControl(VBox vbox, Label dateLabel, Label cityNameLabel, Label sunriseTimeLabel,
                                 Label sunsetTimeLabel, Label temperatureLabel, Label weatherDescriptionLabel,
                                 Label windLabel, Label humidityLabel, Label pressureLabel,
                                 WeatherIconView weatherIcon) {
        this.vBox = vbox;
        this.dateLabel = dateLabel;
        this.cityNameLabel = cityNameLabel;
        this.sunriseTimeLabel = sunriseTimeLabel;
        this.sunsetTimeLabel = sunsetTimeLabel;
        this.temperatureLabel = temperatureLabel;
        this.weatherDescriptionLabel = weatherDescriptionLabel;
        this.windLabel = windLabel;
        this.humidityLabel = humidityLabel;
        this.pressureLabel = pressureLabel;
        this.weatherIcon = weatherIcon;
    };

    public void setControlsCurrentWeather(OpenWeatherMap openWeatherMap, Integer cityId) throws APIException {
        CurrentWeatherForecast currentWeatherForecast = new CurrentWeatherForecast(openWeatherMap, cityId);

        dateLabel.setText(currentWeatherForecast.getDate() + currentWeatherForecast.getStrTimeOffset());
        cityNameLabel.setText(currentWeatherForecast.getCityName());
        sunsetTimeLabel.setText(currentWeatherForecast.getSunsetTime());
        sunriseTimeLabel.setText(currentWeatherForecast.getSunriseTime());
        temperatureLabel.setText(currentWeatherForecast.getTemperature());
        weatherDescriptionLabel.setText(currentWeatherForecast.getWeatherDescription());
        windLabel.setText(currentWeatherForecast.getWind());
        humidityLabel.setText(currentWeatherForecast.getHumidity());
        pressureLabel.setText(currentWeatherForecast.getPressure());
        weatherIcon.setGlyphName(currentWeatherForecast.getCurrentWeatherGlyphName());
    }


}
