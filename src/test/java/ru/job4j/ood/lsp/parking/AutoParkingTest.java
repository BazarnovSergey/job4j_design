package ru.job4j.ood.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class AutoParkingTest {

    @Test
    public void when2PassengerAnd1TruckThenTrue() {
        AutoParking autoParking = new AutoParking(2, 1);
        PassengerCar passengerCar1 = new PassengerCar();
        PassengerCar passengerCar2 = new PassengerCar();
        Truck truck1 = new Truck(2);
        Assert.assertTrue(autoParking.parking(passengerCar1));
        Assert.assertTrue(autoParking.parking(passengerCar2));
        Assert.assertTrue(autoParking.parking(truck1));
    }

    @Test
    public void
    whenSecondTruckDoesNotHaveEnoughSpaceInCarParking() {
        AutoParking autoParking = new AutoParking(2, 1);
        Truck truck1 = new Truck(2);
        Truck truck2 = new Truck(3);
        Assert.assertTrue(autoParking.parking(truck1));
        Assert.assertFalse(autoParking.parking(truck2));
    }

    @Test
    public void whenPassengerInTruckParking() {
        AutoParking autoParking = new AutoParking(0, 1);
        PassengerCar passengerCar1 = new PassengerCar();
        Assert.assertFalse(autoParking.parking(passengerCar1));
    }

    @Test
    public void whenSize3TruckIsParkedFor2Passenger() {
        AutoParking autoParking = new AutoParking(2, 0);
        Truck truck1 = new Truck(3);
        Assert.assertFalse(autoParking.parking(truck1));
    }
}