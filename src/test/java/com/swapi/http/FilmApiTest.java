package com.swapi.http;

import com.swapi.model.Film;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FilmApiTest {

    private FilmApi filmApi;

    @Before
    public void setUp() throws Exception {
        filmApi = new FilmApi();
    }

    @Test
    public void listFilms() throws Exception {
        List<Film> films = filmApi.listFilms();
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

    @Test
    public void searchFilm() throws Exception {
        List<Film> result = filmApi.searchFilms("force");
        assertEquals(1, result.size());
        Film film = result.get(0);
        assertEquals("J. J. Abrams", film.director);
        assertEquals("Kathleen Kennedy, J. J. Abrams, Bryan Burk", film.producer);
        assertArrayEquals(new String[]{"http://swapi.co/api/people/1/","http://swapi.co/api/people/3/", "http://swapi.co/api/people/5/", "http://swapi.co/api/people/13/", "http://swapi.co/api/people/14/", "http://swapi.co/api/people/27/", "http://swapi.co/api/people/84/", "http://swapi.co/api/people/85/", "http://swapi.co/api/people/86/", "http://swapi.co/api/people/87/", "http://swapi.co/api/people/88/"}, film.charactersUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/planets/61/"}, film.planetsUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/species/3/", "http://swapi.co/api/species/2/", "http://swapi.co/api/species/1/"}, film.speciesUrls.toArray(new String[0]));
        assertArrayEquals(new String[]{"http://swapi.co/api/starships/77/", "http://swapi.co/api/starships/10/"}, film.starshipsUrls.toArray(new String[0]));
        assertArrayEquals(new String[0], film.vehiclesUrls.toArray(new String[0]));
        assertEquals("Luke Skywalker has vanished.\r\nIn his absence, the sinister\r\nFIRST ORDER has risen from\r\nthe ashes of the Empire\r\nand will not rest until\r\nSkywalker, the last Jedi,\r\nhas been destroyed.\r\n \r\nWith the support of the\r\nREPUBLIC, General Leia Organa\r\nleads a brave RESISTANCE.\r\nShe is desperate to find her\r\nbrother Luke and gain his\r\nhelp in restoring peace and\r\njustice to the galaxy.\r\n \r\nLeia has sent her most daring\r\npilot on a secret mission\r\nto Jakku, where an old ally\r\nhas discovered a clue to\r\nLuke's whereabouts....", film.openingCrawl);
        assertEquals("The Force Awakens", film.title);
        assertEquals("http://swapi.co/api/films/7/", film.url);
        assertEquals(7, film.episodeId);
    }
}