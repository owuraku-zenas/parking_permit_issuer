package io.turntabl.vehicle;

import io.turntabl.person.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MotorbikeTest {
    @Test
    void testGetTotalChargeForLessThanCapacity() {
        Vehicle motorbike = new Motorbike("GT893893",
                List.of(new Person("3e3ei2", "Kwame Dapaah")), 800);

        assertEquals(Motorbike.baseCharge(), motorbike.getTotalCharge());
    }

    @Test
    void testGetTotalChargeForGreaterThanCapacity() {
        Vehicle motorbike = new Motorbike("GT893893",
                List.of(new Person("3e3ei2", "Kwame Dapaah")), 870);

        assertEquals(Motorbike.advancedCharge(), motorbike.getTotalCharge());
    }

    @Test
    void testGetTotalChargeForBaseCapacity() {
        Vehicle motorbike = new Motorbike("GT893893",
                List.of(new Person("3e3ei2", "Kwame Dapaah")), 850);

        assertEquals(Motorbike.baseCharge(), motorbike.getTotalCharge());
    }
}