package ru.job4j.ood.lsp.parking;

public class Truck implements Car {

    private final int size;

    @Override
    public int getSize() {
        return size;
    }

    public Truck(int size) {
        if (size <= PassengerCar.CAR_SIZE) {
            throw new IllegalArgumentException("Автомобиль не является грузовым");
        }
        this.size = size;
    }
}