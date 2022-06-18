package ru.job4j.ood.dip;

/**
 *  Класс Car зависит от конкретного класса DieselEngine, а не от интерфейса
 */

public class Example3 {

    class Car {
        private DieselEngine engine;

    }

    class DieselEngine {

    }
}