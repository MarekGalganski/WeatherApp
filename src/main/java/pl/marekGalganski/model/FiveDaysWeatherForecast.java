package pl.marekGalganski.model;

import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;
import pl.marekGalganski.model.subsidiaryClasses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class FiveDaysWeatherForecast {

    private HourlyWeatherForecast hourlyWeatherForecast;
    private List<DataToLineChart> listOfDataToLineChart;

    public FiveDaysWeatherForecast(OpenWeatherMap openWeatherMap, Integer cityId) throws APIException {
        this.hourlyWeatherForecast = openWeatherMap.getHourlyWeather(cityId);
        listOfDataToLineChart = new ArrayList<>();
    }

    public void setFiveDaysForecast(VBox weatherChart) {
        weatherChart.getChildren().clear();

        String chartTitle= "";
        String previousDayName = "";
        int index = 1;

        for(WeatherData data: hourlyWeatherForecast.getDataList()) {

            WeatherDataService weatherDataService = new WeatherDataService(data, getTimeZoneOfTheCity());
            String time = weatherDataService.getTime();
            int temperature = weatherDataService.getTemperature();
            String iconCode = weatherDataService.getIconCode();
            String day = weatherDataService.getDay();

            if(!day.equals(previousDayName)) {
                chartTitle += Formatter.firstLetterToUpper(day) + "/";
            }

            previousDayName = day;

            DataToLineChart dataToLineChart = new DataToLineChart(temperature, time, iconCode);
            listOfDataToLineChart.add(dataToLineChart);

            if (index % 8 == 0) {
                buildChart(weatherChart, Formatter.stringWithoutLastChar(chartTitle));
                chartTitle = "";
                previousDayName = "";
                listOfDataToLineChart.clear();
            }
            index ++;

        }

    }

    private void buildChart(VBox weatherVBox, String days) {

        Label label = new Label(days);
        label.setPadding(new Insets(30,0,0,0));
        label.getStyleClass().add("text-18");

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

        WeatherChart weatherChart = new WeatherChart(lineChart, yAxis, xAxis);
        weatherChart.setChart(listOfDataToLineChart);

        weatherVBox.getChildren().addAll(label, lineChart);


    }

    private TimeZone getTimeZoneOfTheCity() {

        TimeZoneOfCity timeZoneOfCity = new TimeZoneOfCity();
        return timeZoneOfCity.getTimeZoneOfTheCity(getLatitude(), getLongitude());
    }

    private double getLatitude() {

        return hourlyWeatherForecast.getCityData().getCoordData().getLatitude();
    }

    private double getLongitude() {

        return hourlyWeatherForecast.getCityData().getCoordData().getLongitude();
    }
}
