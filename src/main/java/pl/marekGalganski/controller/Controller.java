package pl.marekGalganski.controller;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    private GridPane mainGrid;

    @FXML
    private VBox currentLocationVBox;

    @FXML
    private TextField currentLocationTextFieldSearch;

    @FXML
    private Label currentLocationWarningLabel;

    @FXML
    private ScrollPane currentLocationScrollPane;

    @FXML
    private VBox currentLocationForecastVBox;

    @FXML
    private Label currentLocationDayLabel;

    @FXML
    private Label currentLocationCityName;

    @FXML
    private Label currentLocationSunriseTime;

    @FXML
    private Label currentLocationSunsetTime;

    @FXML
    private Label currentLocationWeatherDescription;

    @FXML
    private WeatherIconView currentLocationWeatherIcon;

    @FXML
    private Label currentLocationMainTemperature;

    @FXML
    private Label currentLocationWindSpeed;

    @FXML
    private Label currentLocationHumidity;

    @FXML
    private Label currentLocationPressure;

    @FXML
    private VBox currentLocationChartBox;

    @FXML
    private VBox travelLocationVBox;

    @FXML
    private TextField travelLocationTextFieldSearch;

    @FXML
    private Label travelLocationWarningLabel;

    @FXML
    private ScrollPane travelLocationScrollPane;

    @FXML
    private VBox travelLocationForecastVBox;

    @FXML
    private Label travelLocationDayLabel;

    @FXML
    private Label travelLocationCityName;

    @FXML
    private Label travelLocationSunriseTime;

    @FXML
    private Label travelLocationSunsetTime;

    @FXML
    private Label travelLocationWeatherDescription;

    @FXML
    private WeatherIconView travelLocationWeatherIcon;

    @FXML
    private Label travelLocationMainTemperature;

    @FXML
    private Label travelLocationWindSpeed;

    @FXML
    private Label travelLocationHumidity;

    @FXML
    private Label travelLocationPressure;

    @FXML
    private VBox travelLocationChartBox;

    @FXML
    void currentLocationBtn(ActionEvent event) {

    }

    @FXML
    void travelLocationBtn(ActionEvent event) {

    }

}




