package io.turntabl.vehicle;

import io.turntabl.person.Person;

import java.util.List;

public class Truck extends Vehicle{
    private static final double BASE_CHARGE = 30;
    private static final VehicleType VEHICLE_TYPE = VehicleType.TRUCK;
    private static final double EXTRA_CHARGE_PER_20_KG = 5;
    private static final double BASE_CAPACITY = 150;
    private final double capacity;

    public Truck(String numberPlate, List<Person> owners, double capacity) {
        super(BASE_CHARGE, numberPlate, owners, VEHICLE_TYPE);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public double getTotalCharge() {
        double extraCapacity = (capacity - BASE_CAPACITY) < 0 ? 0 : capacity - BASE_CAPACITY;

        double extraCharge = Math.ceil(extraCapacity / 20.0) * EXTRA_CHARGE_PER_20_KG;

        return extraCharge + getBaseCharge();
    }

    public static double baseCapacity() {
        return BASE_CAPACITY;
    }

    public static double baseCharge() {
        return BASE_CHARGE;
    }
}
