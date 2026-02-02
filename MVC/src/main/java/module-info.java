module mvc_fx {
    requires javafx.controls;
    requires javafx.fxml;

    opens mvc_fx to javafx.fxml;
    exports mvc_fx;
}
