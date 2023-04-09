package com.example.demo3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Locale;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    private Label lblTitle = new Label("TableView example");
    private Button btnRefresh = new Button("Refresh");
    private Button btnAdd = new Button("Add new Category");
    private TableView<Category> tableView = new TableView<Category>();

    //Columns
    private TableColumn columnCategoryID = new TableColumn("category's ID");
    private TableColumn columnCategoryName = new TableColumn("category's Name");
    private TableColumn columnDescription = new TableColumn("description");

    private Category selectedCategory;

    private ContextMenu contextMenu = new ContextMenu();
    private MenuItem menuItemDelete = new MenuItem("Delete");;
    private MenuItem menuItemProperty = new MenuItem("Properties");

    @Override
    public void start(Stage primaryStage)   {

        primaryStage.setTitle("TableView of categories example!");
        btnRefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.getInstance().getAllCategories();
            }
        });
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("adasdsa");
                showDetailCategory(null);
            }
        });
        contextMenu.getItems().addAll(menuItemDelete,menuItemProperty);
        menuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("you pressed delete" + selectedCategory.getCategoryName());
                Database.getInstance().deleteACategory(selectedCategory.getCategoryID());
                Database.getInstance().getAllCategories();
            }
        });
        menuItemProperty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("you pressed Property"+selectedCategory.getCategoryName());
                showDetailCategory(selectedCategory);
            }
        });
        columnCategoryID.setMinWidth(100);
        columnCategoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));

        columnCategoryName.setMinWidth(200);
        columnCategoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        columnDescription.setMinWidth(300);
//        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableView.getColumns().addAll(columnCategoryID,columnCategoryName,columnDescription);
        Database database = new Database();
        System.out.println("database data: " +database.getAllCategories());
        tableView.setItems(Database.getInstance().getAllCategories());
        tableView.setRowFactory(tv ->{
            final TableRow<Category> row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    contextMenu.hide();
                    selectedCategory = row.getItem();
                    //Double click
                    if(mouseEvent.getClickCount() == 2 && !row.isEmpty()) {
                        System.out.println("You double-clicked a row");
                        showDetailCategory(selectedCategory);
                    } else if(mouseEvent.getButton() == MouseButton.SECONDARY) {
                        selectedCategory = row.getItem();
                        contextMenu.show(tableView, mouseEvent.getScreenX(), mouseEvent.getScreenY());
                        System.out.println("You right-clicked a row");
                        menuItemProperty.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                showDetailCategory(selectedCategory);
                            }
                        });
                    }
                }
            });
            return row;
        });
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(lblTitle,btnRefresh, btnAdd,tableView);
        lblTitle.setFont(new Font("Arial", 25));
        Scene scene = new Scene(vbox, 600, 320);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void showDetailCategory(Category selectedCategory){
        DetailCategory detailCategory = new DetailCategory(selectedCategory,"Detail Category");

        detailCategory.initModality(Modality.APPLICATION_MODAL);
        detailCategory.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                System.out.println("Detail category is hiding");
                Database.getInstance().getAllCategories();
            }
        });
        detailCategory.showAndWait();

    }

}