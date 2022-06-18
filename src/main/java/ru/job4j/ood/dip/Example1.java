package ru.job4j.ood.dip;

/**
 * Нарушение DIP в том что Client использует класс DataAccess.
 * Необходимо создать интерфейс DAO и имплементироапть его в DataAccess.
 * В классе Client использовать интерфейс.
 */

public class Example1 {
    class DataAccess {
        void execute() {
            System.out.printf("execute");
        }
    }

    class Client {
        DataAccess dataAccess = new DataAccess();

        void doJob() {
            dataAccess.execute();
        }
    }
}