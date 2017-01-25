package com.swapi.http;

import com.swapi.models.Film;
import com.swapi.models.Planet;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
    public void listFilms() throws Exception {
        List<Film> films = starWarsApi.listFilms();
        assertEquals(7, films.size());
        Film film = films.get(0);
        assertEquals("George Lucas", film.director);
        assertEquals("Gary Kurtz, Rick McCallum", film.producer);
        assertArrayEquals(new String[]{"http://swapi.co/api/people/1/", "http://swapi.co/api/people/2/", "http://swapi.co/api/people/3/", "http://swapi.co/api/people/4/", "http://swapi.co/api/people/5/", "http://swapi.co/api/people/6/", "http://swapi.co/api/people/7/", "http://swapi.co/api/people/8/", "http://swapi.co/api/people/9/", "http://swapi.co/api/people/10/", "http://swapi.co/api/people/12/", "http://swapi.co/api/people/13/", "http://swapi.co/api/people/14/", "http://swapi.co/api/people/15/", "http://swapi.co/api/people/16/", "http://swapi.co/api/people/18/", "http://swapi.co/api/people/19/", "http://swapi.co/api/people/81/"}, film.charactersUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/planets/2/", "http://swapi.co/api/planets/3/", "http://swapi.co/api/planets/1/"}, film.planetsUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/species/5/", "http://swapi.co/api/species/3/", "http://swapi.co/api/species/2/", "http://swapi.co/api/species/1/", "http://swapi.co/api/species/4/"}, film.speciesUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/starships/2/", "http://swapi.co/api/starships/3/", "http://swapi.co/api/starships/5/", "http://swapi.co/api/starships/9/", "http://swapi.co/api/starships/10/", "http://swapi.co/api/starships/11/", "http://swapi.co/api/starships/12/", "http://swapi.co/api/starships/13/"}, film.starshipsUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/vehicles/4/", "http://swapi.co/api/vehicles/6/", "http://swapi.co/api/vehicles/7/", "http://swapi.co/api/vehicles/8/"}, film.vehiclesUrls.toArray(new String[0]));
        assertEquals("It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....", film.openingCrawl);
        assertEquals("A New Hope", film.title);
        assertEquals("http://swapi.co/api/films/1/", film.url);
        assertEquals(4, film.episodeId);
    }
}