module stu_110502521.a8_110502521 {
    requires javafx.controls;
    requires javafx.fxml;


    opens encoder to javafx.fxml;
    exports encoder;
}