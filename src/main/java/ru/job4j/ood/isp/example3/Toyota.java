package ru.job4j.ood.isp.example3;

public class Toyota implements Car {

    String name;
    String engine;
    int fuelVolume;

    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void refueling() {
        System.out.println("Refilling the car");
    }

    @Override
    public void charging() {

    }
}