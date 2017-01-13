package com.swapi.sw;

import com.swapi.models.*;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Oleur on 21/12/2014.
 * Star Wars API interface for making calls.
 */
public interface StarWars {

    @GET("/")
    void getRootUrls(Callback<Root> callback);

    @GET("/people/")
    void getAllPeople(@Query("page") int page);

    @GET("/people/{id}/")
    void getPeople(@Path("id") int peopleId);

    @GET("/films/")
    void getAllFilms(@Query("page") int page);

    @GET("/films/{id}/")
    void getFilm(@Path("id") int filmId);

    @GET("/starships")
    void getAllStarships(@Query("page") int page);

    @GET("/starships/{id}/")
    void getStarship(@Path("id") int starshipId);

    @GET("/vehicles/")
    void getAllVehicles(@Query("page") int page);

    @GET("/vehicles/{id}/")
    void getVehicle(@Path("id") int vehicleId);

    @GET("/species/")
    void getAllSpecies(@Query("page") int page);

    @GET("/species/{id}/")
    void getSpecies(@Path("id") int speciesId);

    @GET("/planets/")
    void getAllPlanets(@Query("page") int page,
                       Callback<SWModelList<Planet>> callback);

    @GET("/planets/{id}/")
    void getPlanet(@Path("id") int planetId);

}
