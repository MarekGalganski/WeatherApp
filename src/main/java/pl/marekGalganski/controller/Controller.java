package pl.marekGalganski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private VBox currentLocationForecastVBox;

    @FXML
    private VBox travelLocationVBox;

    @FXML
    void currentLocationBtn(ActionEvent event) {

    }


}


