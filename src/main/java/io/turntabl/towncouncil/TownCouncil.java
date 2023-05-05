package io.turntabl.towncouncil;

import io.turntabl.exception.InvalidOwnerException;
import io.turntabl.exception.PermitAlreadyIssuedException;
import io.turntabl.person.Person;
import io.turntabl.vehicle.Vehicle;
import io.turntabl.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class TownCouncil {

    private final Map<VehicleType, Integer> numberOfVehicleTypes = new HashMap<>();
    private static int numberOfPermits = 0;



    public void issuePermit(Person person, Vehicle vehicle) throws InvalidOwnerException, PermitAlreadyIssuedException {

        // Check whether person in an owner of vehicle
        if (!vehicle.getOwners().contains(person)) {
            throw new InvalidOwnerException(person.getName() + "Is not an Owner of the Vehicle");
        }

        // Check if vehicle already
        boolean vehicleHasPermit = vehicle.getParkingPermit() == null;
        if (!vehicleHasPermit) throw new PermitAlreadyIssuedException("Vehicle already has a permit");

        // Issue Permit to Vehicle
        vehicle.setParkingPermit("PN" + ++numberOfPermits);
        numberOfPermits++;

        // Increment the number of vehicles for that vehicle's type
        int numberOfVehicles = numberOfVehicleTypes.getOrDefault(vehicle.getVehicleType(), 0);
        numberOfVehicleTypes.put(vehicle.getVehicleType(), numberOfVehicles+1);
    }

    public Map<VehicleType, Integer> getNumberOfVehicleTypes() {
        return numberOfVehicleTypes;
    }
}
