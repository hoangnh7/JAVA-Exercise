package com.example.tabviewjavafx;

import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleStringProperty name;
    private final SimpleStringProperty yearOfProduction;
    private final SimpleStringProperty description;
    private final SimpleStringProperty status;

    //Constructor
    public Product(String name,String yearOfProduction,String desciption , String status){
        this.name = new SimpleStringProperty(name);
        this.yearOfProduction = new SimpleStringProperty(yearOfProduction);
        this.description = new SimpleStringProperty(desciption);
        this.status = new SimpleStringProperty(status);
    }
    //setter
    public void setName(String name) {
        this.name.set(name);
    }
    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction.set(yearOfProduction);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
    //getter
    public String getName() {
        return this.name.get();
    }
    public String getYearOfProduction() {
        return this.yearOfProduction.get();
    }

    public String getDescription() {
        return this.description.get();
    }

    public String getStatus() {
        return this.status.get();
    }
}
