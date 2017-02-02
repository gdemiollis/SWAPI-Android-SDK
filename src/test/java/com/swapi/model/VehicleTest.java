package com.swapi.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle vehicle;

    @Before
    public void setUp() throws Exception {
        vehicle = new Vehicle();
    }

    @Test
    public void isEmpire() throws Exception {
        vehicle.manufacturer = "Sienar";
        assertTrue(vehicle.isEmpire());
        vehicle.manufacturer = "Kuat";
        assertTrue(vehicle.isEmpire());
        vehicle.manufacturer = "Imperial";
        assertTrue(vehicle.isEmpire());
        vehicle.manufacturer = "Aratech";
        assertTrue(vehicle.isEmpire());
        vehicle.manufacturer = "Falcon";
        assertFalse(vehicle.isEmpire());
    }

}