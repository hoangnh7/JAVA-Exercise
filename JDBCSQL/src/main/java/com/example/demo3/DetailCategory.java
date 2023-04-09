package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailCategory extends Stage {
    private Category category;
    private Scene scene = new Scene(new Group(),380,250);
    private GridPane gridPane = new GridPane();
    private Text scenetitle = new Text("");

    private Label lblName        = new Label("Category's name");
    private Label lblDescription = new Label("Description");

    private TextField txtName        = new TextField();
    private TextField txtDescription = new TextField();

    private Button btnOK      = new Button("OK");
    private Button btnCancel  = new Button("Cancel");
    public DetailCategory(Category category,String sceneTitle){
        super();
        if (category != null){
            this.category= category;
            txtName.setText(category.getCategoryName());
            txtDescription.setText(category.getDescription());
        }
        layoutMyScene();
        this.scenetitle.setText(sceneTitle);
        this.scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,25));
        this.scenetitle.setText(sceneTitle);
        gridPane.add(this.scenetitle,0,0,2,1);
        this.scene.setRoot(gridPane);
        this.setScene(this.scene);
    }
    private void layoutMyScene(){
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,
                25, 25, 25));
        gridPane.add(lblName, 0, 1);
        gridPane.add(txtName, 1, 1);

        gridPane.add(lblDescription, 0, 2);
        gridPane.add(txtDescription, 1, 2);

        txtName.setPromptText("Enter category's name");
        txtDescription.setPromptText("Enter category's description");
        HBox hbox2Buttons = new HBox(10);
        hbox2Buttons.setAlignment(Pos.BOTTOM_RIGHT);
        hbox2Buttons.setSpacing(15);
        hbox2Buttons.getChildren().setAll(btnOK, btnCancel);
        gridPane.add(hbox2Buttons,0, 3, 2,1);

        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Validate
                String typedText = txtName.getText();
                String typedDescription = txtDescription.getText();
                if (typedText.trim().equals("") || typedDescription.trim().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setContentText("You must enter category's name and description");
                    alert.showAndWait();
                    return;
                }
                if (category == null) {
                    //Insert
                    Database.getInstance().addNewCategory(txtName.getText(), txtDescription.getText());
                } else {
                    //Update
                    Database.getInstance().updateACategory(category.getCategoryID(),
                            txtName.getText(),
                            txtDescription.getText());
                }

                closeStage();
            }

        });
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                closeStage();
            }
        });
    }
    private void closeStage(){
        this.close();
    }
}
