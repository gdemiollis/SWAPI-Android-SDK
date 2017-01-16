package com.swapi.http;

import com.swapi.models.Planet;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StarWarsApiTest {

    private StarWarsApi starWarsApi;

    @Before
    public void setUp() throws Exception {
        starWarsApi = new StarWarsApi();
    }

    @Test
    public void listPlanets() throws Exception {
        List<Planet> planets = starWarsApi.listPlanets();
        assertEquals(10, planets.size());

    }
}