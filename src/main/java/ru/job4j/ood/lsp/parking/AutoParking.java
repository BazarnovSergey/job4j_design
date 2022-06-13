package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class AutoParking implements ParkingCar {

    private int passengerPlaces;
    private int truckPlaces;
    private List<Car> parkingList;

    public AutoParking(int passengerPlaces, int truckPlaces) {
        this.passengerPlaces = passengerPlaces;
        this.truckPlaces = truckPlaces;
        this.parkingList = new ArrayList<>(passengerPlaces + truckPlaces);
    }

    public int getPassengerPlaces() {
        return passengerPlaces;
    }

    public int getTruckPlaces() {
        return truckPlaces;
    }

    public List<Car> getParkingList() {
        return new ArrayList<>(parkingList);
    }

    @Override
    public boolean parking(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("No Car");
        }
        boolean rzl = false;
        int carSize = car.getSize();
        if (carSize == PassengerCar.CAR_SIZE && passengerPlaces >= PassengerCar.CAR_SIZE) {
            parkingList.add(car);
            passengerPlaces--;
            rzl = true;
        } else if (carSize > PassengerCar.CAR_SIZE && truckPlaces >= PassengerCar.CAR_SIZE) {
            parkingList.add(car);
            truckPlaces--;
            rzl = true;
        } else if (carSize > PassengerCar.CAR_SIZE && carSize <= passengerPlaces) {
            parkingList.add(car);
            passengerPlaces -= carSize;
            rzl = true;
        }
        return rzl;
    }
}