package com.swapi.http;

import com.swapi.model.People;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PeopleApiTest {

    private PeopleApi peopleApi;

    @Before
    public void setUp() throws Exception {
        peopleApi = new PeopleApi();
    }

    @Test
    public void listPeople() throws Exception {
        List<People> people = peopleApi.listPeople();
        assertEquals(10, people.size());
        People luke = people.get(0);
        assertEquals("Luke Skywalker", luke.name);
        assertEquals("19BBY", luke.birthYear);
        assertEquals("male", luke.gender);
        assertEquals("blond", luke.hairColor);
        assertEquals("172", luke.height);
        assertEquals("http://swapi.co/api/planets/1/", luke.homeWorldUrl);
        assertEquals("77", luke.mass);
        assertEquals("fair", luke.skinColor);
        assertEquals("http://swapi.co/api/people/1/", luke.url);
        assertEquals(1, luke.speciesUrls.size());
        assertEquals(5, luke.filmsUrls.size());
        assertEquals(2, luke.starshipsUrls.size());
        assertEquals(2, luke.vehiclesUrls.size());
    }

    @Test
    public void searchPeople() throws Exception {
        List<People> result = peopleApi.searchPeople("r2");
        assertEquals(1, result.size());
        People r2 = result.get(0);
        assertEquals("33BBY", r2.birthYear);
        assertEquals("96", r2.height);
        assertEquals("http://swapi.co/api/planets/8/", r2.homeWorldUrl);
        assertEquals("32", r2.mass);
        assertEquals("white, blue", r2.skinColor);
        assertEquals("http://swapi.co/api/people/3/", r2.url);
        assertEquals(1, r2.speciesUrls.size());
        assertEquals(7, r2.filmsUrls.size());
        assertEquals(0, r2.starshipsUrls.size());
        assertEquals(0, r2.vehiclesUrls.size());

    }
}