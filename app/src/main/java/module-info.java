module programa {
    requires javafx.controls;
    requires javafx.fxml;

    opens programa to javafx.fxml;
    exports programa;
}
