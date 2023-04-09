module com.example.barchart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.barchart to javafx.fxml;
    exports com.example.barchart;
}