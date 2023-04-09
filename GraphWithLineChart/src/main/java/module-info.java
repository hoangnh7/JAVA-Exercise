module com.example.graphwithlinechart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.graphwithlinechart to javafx.fxml;
    exports com.example.graphwithlinechart;
}