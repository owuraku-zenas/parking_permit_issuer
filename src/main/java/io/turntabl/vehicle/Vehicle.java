package io.turntabl.vehicle;

import io.turntabl.person.Person;

import java.util.List;

public abstract class Vehicle {
    private final double baseCharge;
    private final String numberPlate;
    private final List<Person> owners;
    private final VehicleType vehicleType;
    private String parkingPermit;

    public Vehicle(double baseCharge, String numberPlate, List<Person> owners, VehicleType vehicleType) {
        this.baseCharge = baseCharge;
        this.numberPlate = numberPlate;
        this.owners = owners;
        this.vehicleType = vehicleType;
    }

    public double getBaseCharge() {
        return baseCharge;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public List<Person> getOwners() {
        return owners;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getParkingPermit() {
        return parkingPermit;
    }

    public void setParkingPermit(String parkingPermit) {
        this.parkingPermit = parkingPermit;
    }

    public abstract double getTotalCharge();
}
