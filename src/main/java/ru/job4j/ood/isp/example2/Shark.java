package ru.job4j.ood.isp.example2;

public class Shark implements Animals {
    @Override
    public void eat() {
        System.out.println("Shark eats");
    }

    @Override
    public void drink() {
        System.out.println("Shark drinking");
    }

    @Override
    public void run() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {
        System.out.println("Shark swimming");
    }
}