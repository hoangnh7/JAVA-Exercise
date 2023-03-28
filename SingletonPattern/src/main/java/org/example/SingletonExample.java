package org.example;


public class SingletonExample {
//    private static  final  SingletonExample instance = new SingletonExample();
//    private static SingletonExample  getInstance(){
    private static  SingletonExample instance;
    //Lấy ra đối tượng singleton
    public static SingletonExample getInstance() {
        if (instance == null) {
            System.out.println("instance now null");
        }
        return  instance;
    }
    public void method1(){
        System.out.println("method 1");
    }
}
