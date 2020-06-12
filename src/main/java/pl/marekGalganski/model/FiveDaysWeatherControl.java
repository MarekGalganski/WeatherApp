package pl.marekGalganski.model;

import javafx.beans.binding.ObjectExpression;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;

public class FiveDaysWeatherControl {

    private VBox chartVBox;
    private Label warningLabel;
    private ScrollPane scrollPane;

    public FiveDaysWeatherControl(VBox chartVBox, Label warningLabel, ScrollPane scrollPane) {
        this.chartVBox = chartVBox;
        this.warningLabel = warningLabel;
        this.scrollPane = scrollPane;
    }

    public void setControlsOfFiveDaysWeather(OpenWeatherMap openWeatherMap, Integer cityId) throws APIException {
        FiveDaysWeatherForecast fiveDaysWeatherForecast = new FiveDaysWeatherForecast(openWeatherMap, cityId);
        fiveDaysWeatherForecast.setFiveDaysForecast(chartVBox);
        warningLabel.setText("");
        scrollPane.setVvalue(0.0);
    }
}
