package ru.job4j.ood.ocp;

import java.util.ArrayList;

public class Example {

    /**
     * В будущем, если понадобится расчитать площадь треугольника
     * придется написать еще один метод. Это приведет к измению программы
     * что является нарушением принципа OCP. Изменение программы может
     * привести к ее некорректной работе.
     * Что бы иметь возможность расширять функционал, нужно создать
     * интерфейс Area, и имплементировать его для каждой фигуры.
     */

    class AreaSquare {

        public double area(int a, int b) {
            return a * b;
        }
    }

    /**
     * при наследовании класса Car, поле fuelConsumption будет лишним,
     * например если это будет электромобиль, он расходует электричество, а не топливо
     */

    class Car {

        int name;
        int fuelConsumption;

        public void drive(String contact) {
            System.out.println("drive");
        }
    }

    /**
     * Класс нарушает принцип OCP, поскольку метод возвращает конкретную реализацию ArrayList
     * Взаимодействие должно осуществляться через абстракции, в данном случае через интерфейс List
     */
    class PhoneBook {

        ArrayList<String> book;

        private ArrayList<String> add(String contact) {
            book.add(contact);
            return book;
        }
    }
}
