package io.turntabl.vehicle;

import io.turntabl.person.Person;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class PrivateCarTest {

    private Vehicle privateCar;

    @BeforeEach
    void setUp() {
        privateCar = new PrivateCar("GT2943Z",
              List.of(new Person("weew", "John Doe"))
        );
    }

    @org.junit.jupiter.api.Test
    void testGetTotalCharge() {
        assertEquals(20, privateCar.getTotalCharge());
    }
}