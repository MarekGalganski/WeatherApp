package pl.marekGalganski.model.subsidiaryClasses;

public class DataToLineChart {

    private Integer temperature;
    private String hour;
    private String iconCode;

    public DataToLineChart(Integer temperature, String hour, String iconCode) {
        this.temperature = temperature;
        this.hour = hour;
        this.iconCode = iconCode;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getHour() {
        return hour;
    }

    public String getIconCode() {
        return iconCode;
    }
}
