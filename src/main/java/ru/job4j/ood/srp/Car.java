package ru.job4j.ood.srp;

/**
 * 1. Так как в интерфейсе Transport разный функционал,
 *    нам приходится в класса Car реализовывать метод Fly;
 *    <p>
 * 2. Singleton — подразумевает, что помимо своих основных
 *    обязанностей класс занимается еще и контролированием количества
 *    своих экземпляров, чем нарушает Single Responsibility Principle
 *    <p>
 * 3. Метод sellCar() приводит к смешиванию логики.
 *    У класса должна быть только одна цель
 */
public class Car implements Transport {

    private static Car car;

    private Car() {
    }

    public static Car getInstance() {
        if (car == null) {
            car = new Car();
        }

        return car;
    }

    public void sellCar() {
        System.out.println("Автомобиль продан");
    }

    @Override
    public void drive() {
        System.out.println("Автомобиль движется");
    }

    @Override
    public void fly() {
        System.out.println("Самолет летит");
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
