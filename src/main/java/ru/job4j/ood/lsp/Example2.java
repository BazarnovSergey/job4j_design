package ru.job4j.ood.lsp;

/**
 * Этот код нарушает принцип lsp, поскольку у класса Bird есть дочерний элемент,
 * который неправильно использовал наследование и, следовательно, вызвал проблему.
 * Правельнее было бы выделить два класса, один для птиц которые умеют летать,
 * второй для птиц которые не умеют летать.
 */

public class Example2 {

    public class Bird {
        public void eat() {
            System.out.println("Я умею есть");
        }

        public void fly() {
            System.out.println("Я умею летать");
        }
    }

    public class Penguin extends Bird {
        @Override
        public void eat() {
            System.out.println("Я умею есть");
        }
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Пингвин не умеет летать!");
        }
    }
}

