package com.example.barchart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private CategoryAxis xAxiz = new CategoryAxis();
    private NumberAxis yAxiz = new NumberAxis();
    private BarChart<String,Number>barChart = new BarChart<String,Number>(xAxiz,yAxiz);
    private XYChart.Series seriesA = new XYChart.Series();
    private ObservableList<XYChart.Data> dataA = FXCollections.observableArrayList(
            new XYChart.Data("January", 250.36),
            new XYChart.Data("February", 270.22),
            new XYChart.Data("March", 290.32),
            new XYChart.Data("April", 320.36),
            new XYChart.Data("May", 210.64),
            new XYChart.Data("June", 250.36),
            new XYChart.Data("July", 350.65),
            new XYChart.Data("August", 400.54),
            new XYChart.Data("September", 310.98),
            new XYChart.Data("October", 200.35),
            new XYChart.Data("November", 230.74),
            new XYChart.Data("December", 300.66)
    );
    private XYChart.Series seriesB = new XYChart.Series();

    private final ObservableList<XYChart.Data> dataB = FXCollections.observableArrayList(
            new XYChart.Data("January", 360.36),
            new XYChart.Data("February", 400.40),
            new XYChart.Data("March", 169.56),
            new XYChart.Data("April", 230.69),
            new XYChart.Data("May", 240.32),
            new XYChart.Data("June", 410.16),
            new XYChart.Data("July", 450.98),
            new XYChart.Data("August", 200.6),
            new XYChart.Data("September", 180.76),
            new XYChart.Data("October",190.06),
            new XYChart.Data("November",210.67),
            new XYChart.Data("December",220.66)
    );

    private void configureGraph(){
        xAxiz.setLabel("Months(1-12)");
        yAxiz.setLabel("Millions");
        barChart.setTitle("Bar chart example");
        //Series A
        seriesA.setName("Company A");
        seriesA.getData().addAll(dataA);
        //Series B
        seriesB.setName("Company B");
        seriesB.getData().addAll(dataB);

        barChart.getData().addAll(seriesA, seriesB);
        barChart.getXAxis().setAutoRanging(true);
        barChart.getYAxis().setAutoRanging(true);
    }
    @Override
    public void start(Stage stage) throws IOException {


        stage.setTitle("Hello!");
        configureGraph();
        Scene scene = new Scene(barChart,1200,600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}