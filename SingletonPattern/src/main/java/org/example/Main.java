package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Singleton pattern in Java");
        //"Singleton pattern" = object tồn tại duy nhất trong app, và "Global"
        Logger.getInstance().show("This is Singleton pattern", Logger.INFO);
        Person person = new Person("Hoang");
        person.talkToMe(120);
    }
}