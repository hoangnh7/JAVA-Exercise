package com.example.gridpane;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {
    private GridPane gridPane= new GridPane();
    private Label lblTitle = new Label("Tính toán vay trả góp");
    private TextField txtLoanContent= new TextField();
    private ObservableList<String> companySizes = FXCollections.observableArrayList(
            "1-5 nhân viên",
            "5-10 nhân viên",
            "> 10 nhân viên"
    );
    private ComboBox comboBoxCompanySizes = new ComboBox(companySizes);
    private TextField txtMoney = new TextField();
    private ObservableList<String> months = FXCollections.observableArrayList(
            "3 tháng",
            "6 tháng",
            "12 tháng",
            "24 tháng"
    );
    private ComboBox comboBoxMonths = new ComboBox(months);

    private CheckBox checkBoxEnsurance = new CheckBox("Có bảo hiểm khoản vay");
    private Button btnCalculate = new Button("Tính nhanh");


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)  {
        stage.setTitle("GridPane Example");
        txtLoanContent.setPromptText("Nhập nội dung vay");
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(lblTitle,0,0,2,1);
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD,27));
        gridPane.add(txtLoanContent,0,1,1,1);
        gridPane.add(comboBoxCompanySizes,0,2,1,1);
        comboBoxCompanySizes.setValue(companySizes.get(0));
        gridPane.add(txtMoney,1,1,2,1);
        txtMoney.setPromptText("Số tiền vay");
        txtMoney.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue,
                                String oldValue, String newValue) {
                if (!newValue.matches("\\d*")){
                    txtMoney.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        gridPane.add(comboBoxMonths, 0, 3, 1, 1);
        gridPane.add(checkBoxEnsurance, 1, 3, 1, 1);
        gridPane.add(btnCalculate, 0, 4, 1, 1);
        comboBoxMonths.setValue(months.get(0));
        btnCalculate.setStyle("-fx-base: green");
        Scene scene = new Scene(gridPane,400,220);
        stage.setScene(scene);
        stage.show();
    }
}
