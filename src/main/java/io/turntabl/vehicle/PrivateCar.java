package io.turntabl.vehicle;

import io.turntabl.person.Person;

import java.util.List;

public class PrivateCar extends Vehicle{
    private static final double BASE_CHARGE = 20;
    private static final VehicleType VEHICLE_TYPE = VehicleType.PRIVATE_CAR;

    public PrivateCar(String numberPlate, List<Person> owners) {
        super(BASE_CHARGE, numberPlate, owners, VEHICLE_TYPE);
    }


    @Override
    public double getTotalCharge() {
        return getBaseCharge();
    }
}
