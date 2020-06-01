module pl.marekGalganski {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires de.jensd.fx.glyphs.weathericons;
    requires gson;

    exports pl.marekGalganski;
    opens pl.marekGalganski;
    opens pl.marekGalganski.controller;
}