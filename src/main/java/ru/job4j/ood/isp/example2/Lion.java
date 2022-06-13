package ru.job4j.ood.isp.example2;

public class Lion implements Animals {

    @Override
    public void eat() {
        System.out.println("Lion eating");
    }

    @Override
    public void drink() {
        System.out.println("Lion drinking");
    }

    @Override
    public void run() {
        System.out.println("Lion running");
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {
        System.out.println("Lion swimming");
    }
}