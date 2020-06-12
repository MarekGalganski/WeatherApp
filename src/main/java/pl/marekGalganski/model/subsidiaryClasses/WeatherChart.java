package pl.marekGalganski.model.subsidiaryClasses;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.beans.Observable;
import javafx.beans.binding.ObjectExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WeatherChart {

    private LineChart<String, Number> lineChart;
    private NumberAxis numberAxis;
    private CategoryAxis categoryAxis;

    public WeatherChart(LineChart<String, Number> lineChart, NumberAxis numberAxis, CategoryAxis categoryAxis) {
        this.lineChart = lineChart;
        this.numberAxis = numberAxis;
        this.categoryAxis = categoryAxis;
    }

    public void setChart(List<DataToLineChart> list) {

        lineChart.getData().addAll(new XYChart.Series<>(createTemperatureData(list)),
                new XYChart.Series<>(createDataIcon(list)));
        lineChart.setMinHeight(200);
        lineChart.setLegendVisible(false);
        lineChart.getStyleClass().add("bg-chart");

        categoryAxis.setAutoRanging(true);
        categoryAxis.setTickLabelsVisible(true);
        categoryAxis.setTickMarkVisible(true);

        numberAxis.setAutoRanging(false);
        numberAxis.setUpperBound(getUpperBoundOfChart(list) + 10);
        numberAxis.setLowerBound(getLowerBoundOfChart(list) - 10);
    }

    private ObservableList<XYChart.Data<String, Number>> createTemperatureData(List<DataToLineChart> dataToLineChartList) {

        var list = FXCollections.<XYChart.Data<String, Number>>observableArrayList();
        for(DataToLineChart dataToLineChart: dataToLineChartList) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(dataToLineChart.getHour(),
                    dataToLineChart.getTemperature());
            data.setNode(createDataNode(data.YValueProperty()));
            list.add(data);
        }
        return list;
    }

    private static Node createDataNode(ObjectExpression<Number> value) {

        Label label = new Label();
        label.getStyleClass().add("text-black");
        label.textProperty().bind(value.asString());

        Pane pane = new Pane(label);
        pane.setShape(new Circle(6.0));
        pane.setScaleShape(false);

        label.translateYProperty().bind(label.heightProperty().divide(-1.5));

        return pane;
    }

    private ObservableList<XYChart.Data<String, Number>> createDataIcon(List<DataToLineChart> dataToLineChartList) {
        var list = FXCollections.<XYChart.Data<String, Number>>observableArrayList();
        double valueOfAxis = getLowerBoundOfChart(dataToLineChartList) - 5;
        for (DataToLineChart dataToLineChart : dataToLineChartList) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(dataToLineChart.getHour(),
                    valueOfAxis);

            data.setNode(createIconNode(dataToLineChart.getIconCode()));
            list.add(data);
        }
        return list;
    }

    private static Node createIconNode(String iconCode) {
        VBox vBox = new VBox(10);
        WeatherIconView weatherIconView = new WeatherIconView();
        weatherIconView.setGlyphName(GlyphNames.getGlyphName(iconCode));
        weatherIconView.setGlyphSize(16);

        Text text = weatherIconView;
        vBox.getChildren().add(text);

        return vBox;
    }

    private List<Integer> getTemperatureList(List<DataToLineChart> list) {
        List<Integer> temperatureList = new ArrayList<>();
        for (DataToLineChart dataToLineChart : list) {
            temperatureList.add(dataToLineChart.getTemperature());
        }
        return temperatureList;
    }

    private int getClosestDownIntDivisibleByUnitOfYAxis(int number) {
        return (number / 5) * 5;
    }

    private Integer getUpperBoundOfChart(List<DataToLineChart> list) {
        List<Integer> temperatureList = getTemperatureList(list);
        int max = Collections.max(temperatureList);

        return getClosestDownIntDivisibleByUnitOfYAxis(max);
    }

    private Integer getLowerBoundOfChart(List<DataToLineChart> list) {
        List<Integer> temperatureList = getTemperatureList(list);
        int min = Collections.min(temperatureList);

        return getClosestDownIntDivisibleByUnitOfYAxis(min);
    }
}
