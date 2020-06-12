module pl.marekGalganski {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.controls;
    requires de.jensd.fx.glyphs.fontawesome;
    requires de.jensd.fx.glyphs.weathericons;
    requires gson;
    requires java.sql;
    requires org.controlsfx.controls;
    requires owm.japis;
    requires geotimezone;



    exports pl.marekGalganski;

    opens pl.marekGalganski;
    opens pl.marekGalganski.controller;
}