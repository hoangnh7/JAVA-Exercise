package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bắt exception thông qua try catch");
        Integer a = 100;
        Integer b = 0;
//        Integer b= 50;
        Calculation calculation = new Calculation();
        Integer result = calculation.divide2Number(a,b);
        System.out.println("Result = "+ result);
        try {
            calculation.readPortConfig(2000);
            System.out.println("Get port successfully");

        } catch (MyException e){
            System.out.println("Error sms is: "+e.getMessage()+" Code: "+e.getCode());

        }
        
    }
}