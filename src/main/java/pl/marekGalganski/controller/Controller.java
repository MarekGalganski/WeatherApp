package pl.marekGalganski.controller;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pl.marekGalganski.Config;
import pl.marekGalganski.model.AutoCompleteTextField;
import pl.marekGalganski.model.JSONConverter;


import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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

    private Map<String, Integer> citiesMap;


    @FXML
    void travelLocationBtn(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            JSONConverter jsonConverter = new JSONConverter();
            citiesMap = jsonConverter.getCitiesFromJson(Config.FILE_WITH_CITIES);
            System.out.println(citiesMap.get("Warszawa,PL"));
            setAutoCompleteTextField();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private void setAutoCompleteTextField (){
        AutoCompleteTextField.setAutoComplete(currentLocationTextFieldSearch, citiesMap);
        AutoCompleteTextField.setAutoComplete(travelLocationTextFieldSearch, citiesMap);
    }

    @FXML
    void setCurrentLocation(ActionEvent event) {

    }


}




