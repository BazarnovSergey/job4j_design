package ru.job4j.ood.lsp;

/**
 * Класс Square наследуется от Rectangle,
 * а так как у квадрата все стороны равны, в классе Square мы просто
 * задаем ширину и высоту, одну и ту же. В итоге, мы испортили
 * изначальную идею класса Rectangle, в который заложена логика,
 * что стороны могут отличаться. Получается, не меняя базовый класс,
 * мы нарушили принцип lsp .
 * Square должен быть отдельным классом и не наследоваться от Rectangle.
 * Поведение методов не должно изменяться. Если написано, что метод возвращает ширину,
 * значит он и должен возвращать ширину.
 */

public class Example1 {

    class Rectangle {

        private int width;
        private int height;

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    class Square extends Rectangle {

        public void setSize(int size) {
            super.setWidth(size);
            super.setHeight(size);
        }
    }
}