package ru.job4j.ood.isp.example2;

public class Eagle implements Animals {
    @Override
    public void eat() {
        System.out.println("Eagle eats");
    }

    @Override
    public void drink() {
        System.out.println("Eagle drinking");
    }

    @Override
    public void run() {

    }

    @Override
    public void fly() {
        System.out.println("Eagle flying");
    }

    @Override
    public void swim() {

    }
}
