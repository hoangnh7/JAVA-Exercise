module com.example.tabviewjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tabviewjavafx to javafx.fxml;
    exports com.example.tabviewjavafx;
}