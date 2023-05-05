package io.turntabl.vehicle;

import io.turntabl.person.Person;

import java.util.List;

public class Motorbike extends Vehicle{
    private static final double BASE_CHARGE = 7;
    private static final VehicleType VEHICLE_TYPE =  VehicleType.MOTORBIKE;
    private static final double ADVANCED_CHARGE = 10;
    private static final double BASE_CAPACITY = 850;
    private final double capacity;

    public Motorbike(String numberPlate, List<Person> owners, double capacity) {
        super(BASE_CHARGE, numberPlate, owners, VEHICLE_TYPE);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public double getTotalCharge() {
        return (capacity - BASE_CAPACITY) <= 0 ? BASE_CHARGE : ADVANCED_CHARGE;
    }

    public static double baseCharge() {
        return BASE_CHARGE;
    }

    public static double advancedCharge() {
        return ADVANCED_CHARGE;
    }
}
