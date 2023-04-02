module com.example.gridpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gridpane to javafx.fxml;
    exports com.example.gridpane;
}