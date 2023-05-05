package io.turntabl.towncouncil;


import io.turntabl.exception.InvalidOwnerException;
import io.turntabl.exception.PermitAlreadyIssuedException;
import io.turntabl.person.Person;
import io.turntabl.vehicle.PrivateCar;
import io.turntabl.vehicle.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TownCouncilTest {
    private TownCouncil townCouncil;
    private Vehicle privateCar;
    private Person person;

    @BeforeEach
    void setUp() {
        townCouncil = new TownCouncil();
        person = new Person("weew", "John Doe");
        privateCar = new PrivateCar("GT2943Z",
                List.of(person)
        );
    }

    // Check For an Owner
    @Test
    void testForTrueOwner() {
        assertDoesNotThrow(() -> townCouncil.issuePermit(person, privateCar));
    }

    // Check For not an Owner
    @Test
    void testForFalseOwner() {
        Person newPerson = new Person("abc", "Jeff");
        assertThrows(InvalidOwnerException.class, ()->townCouncil.issuePermit(newPerson, privateCar));
    }

    // Check if the number of vehicles for that type has been increased
    @Test
    void testForSuccessfulPermitIssued() throws InvalidOwnerException, PermitAlreadyIssuedException {
        int numberOfVehicles = townCouncil.getNumberOfVehicleTypes().getOrDefault(privateCar.getVehicleType(), 0);


        townCouncil.issuePermit(person, privateCar);
        assertNotNull(privateCar.getParkingPermit());
        assertEquals(numberOfVehicles+1, townCouncil.getNumberOfVehicleTypes().get(privateCar.getVehicleType()));

    }

    // Check if Vehicle Already Has a Permit
    @Test
    void testForVehicleAlreadyWithPermit() throws InvalidOwnerException, PermitAlreadyIssuedException {
        townCouncil.issuePermit(person, privateCar);


        assertThrows(PermitAlreadyIssuedException.class, ()->townCouncil.issuePermit(person, privateCar));
    }

}