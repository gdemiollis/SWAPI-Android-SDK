package com.swapi.http;

import com.swapi.model.Planet;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PlanetApiTest {

    private PlanetApi planetApi;

    @Before
    public void setUp() throws Exception {
        planetApi = new PlanetApi();
    }

    @Test
    public void listPlanets() throws Exception {
        List<Planet> planets = planetApi.listPlanets();
        assertEquals(10, planets.size());
        Planet planet = planets.get(0);
        assertEquals("temperate", planet.climate);
        assertEquals("12500", planet.diameter);
        assertArrayEquals(new String[]{"http://swapi.co/api/people/5/", "http://swapi.co/api/people/68/", "http://swapi.co/api/people/81/"}, planet.residentsUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/films/6/", "http://swapi.co/api/films/1/"}, planet.filmsUrls.toArray(new String[0]));
        assertEquals("1 standard", planet.gravity);
        assertEquals("Alderaan", planet.name);
        assertEquals("2000000000", planet.population);
        assertEquals("24", planet.rotationPeriod);
        assertEquals("364", planet.orbitalPeriod);
        assertEquals("40", planet.surfaceWater);
        assertEquals("http://swapi.co/api/planets/2/", planet.url);
        assertEquals("grasslands, mountains", planet.terrain);
    }

    @Test
    public void searchPlanet() throws Exception {
        List<Planet> result = planetApi.searchPlanet("gob");
        assertEquals(1, result.size());
        Planet planet = result.get(0);
        assertEquals("murky", planet.climate);
        assertEquals("8900", planet.diameter);
        assertArrayEquals(new String[0], planet.residentsUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/films/6/", "http://swapi.co/api/films/3/", "http://swapi.co/api/films/2/"}, planet.filmsUrls.toArray(new String[0]));
        assertEquals("N/A", planet.gravity);
        assertEquals("Dagobah", planet.name);
        assertEquals("unknown", planet.population);
        assertEquals("23", planet.rotationPeriod);
        assertEquals("341", planet.orbitalPeriod);
        assertEquals("8", planet.surfaceWater);
        assertEquals("http://swapi.co/api/planets/5/", planet.url);
        assertEquals("swamp, jungles", planet.terrain);
    }
}