package ru.job4j.ood.isp.example3;

/**
 * Интерфейс реализовывался для автомобилей требующих заправки топливом.
 * Но позже появлились электромобили и потрбовалось ввести метод для зарядки.
 * Сделовало разбить интерфейс на два, для электромобилей и для авто с ДВС.
 */

public interface Car {

    void drive();

    void refueling();

    void charging();

}