module exchange_rate {
    requires javafx.controls;
    requires javafx.fxml;


    opens exchange_rate to javafx.fxml;
    exports exchange_rate;
}