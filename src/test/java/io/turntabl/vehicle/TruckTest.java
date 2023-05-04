package io.turntabl.vehicle;

import io.turntabl.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    @Test
    void testGetTotalChargeForLessThanBaseCapacity() {
        Vehicle truckLessThanBaseCapacity = new Truck("GT2943Z",
                List.of(new Person("weew", "John Doe")),
                120
        );

        assertEquals(Truck.baseCharge(), truckLessThanBaseCapacity.getTotalCharge());
    }

    @Test
    void testGetTotalChargeForBaseCapacity() {
        Vehicle truckBaseCapacity = new Truck("GT2943Z",
                List.of(new Person("weew", "John Doe")),
                Truck.baseCapacity()
        );

        assertEquals(Truck.baseCharge(), truckBaseCapacity.getTotalCharge());
    }

    @Test
    void testGetTotalChargeForGreaterThanBaseCapacity() {

        Vehicle truckGreaterThanBaseCapacity = new Truck("GT2943Z",
                List.of(new Person("weew", "John Doe")),
                200
        );

        assertEquals(45, truckGreaterThanBaseCapacity.getTotalCharge());
    }



}