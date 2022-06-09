package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class AutoParking implements ParkingCar {

    private int carPlaces;
    private int truckPlaces;
    private List<Car> parkingList = new ArrayList<>();

    public AutoParking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
    }

    public int getCarPlaces() {
        return carPlaces;
    }

    public int getTruckPlaces() {
        return truckPlaces;
    }

    public List<Car> getParkingList() {
        return parkingList;
    }

    @Override
    public boolean parking(Car car) {
        return false;
    }
}