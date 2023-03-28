package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Runnable r1 = new Runnable() {
            private Thread thread;
            public void start() {
                System.out.println("Starting ThreadA");
                if(thread == null) {
                    thread = new Thread(this, "ThreadA");
                }
            }
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 5; i++) {
                        System.out.println("ThreadA is running step "+i);
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    System.out.println("ThreadA is interrupted because of Error : "+e.getMessage());
                }
                System.out.println("ThreadA is ended");
            }
        };
        Thread thread1 = new Thread(r1, "ThreadA");
        Runnable r2 = new Runnable() {
            private Thread thread;
            public void start() {
                System.out.println("Starting ThreadB");
                if (thread == null) {
                    thread = new Thread (this, "ThreadB");
                    thread.start();
                }
            }
            //Create an object that implement Runable interface
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; i++) {
                        System.out.println("ThreadB is running step " + i);
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    System.out.println("ThreadB is interrupted because of Error : "+e.getMessage());
                }
                System.out.println("ThreadB is ended");
            }
        };
        Thread thread2 = new Thread(r2, "ThreadB");
        thread1.start();
        thread2.start();    }
}