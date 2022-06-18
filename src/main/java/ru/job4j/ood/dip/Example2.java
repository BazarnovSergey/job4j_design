package ru.job4j.ood.dip;

/**
 * Метод driveTransport() нарушает принцип DIP тем,
 * что принимает на вход реализацию, вместо абстракции.
 */

public class Example2 {

    public interface Transport {
        void driveTransport(Car car);

    }

    class Car implements Transport {
        @Override
        public void driveTransport(Car car) {
            System.out.println("Drive car");
        }
    }

    class Bus implements Transport {
        @Override
        public void driveTransport(Car car) {
            System.out.println("Drive bus");
        }
    }
}
