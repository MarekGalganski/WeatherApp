module pl.marekGalganski {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;

    exports pl.marekGalganski;
    opens pl.marekGalganski;
    opens pl.marekGalganski.controller;
}