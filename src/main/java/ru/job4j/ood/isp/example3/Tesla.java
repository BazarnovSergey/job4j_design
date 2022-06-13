package ru.job4j.ood.isp.example3;

public class Tesla implements Car {

    String name;
    int batteryCapacity;

    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void refueling() {

    }

    @Override
    public void charging() {
        System.out.println("Сar charging");
    }
}
