package com.swapi.http;

import com.swapi.model.Film;
import com.swapi.model.People;
import com.swapi.model.Planet;
import com.swapi.model.Root;
import com.swapi.model.SWModelList;
import com.swapi.model.Species;
import com.swapi.model.Starship;
import com.swapi.model.Vehicle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Oleur on 21/12/2014.
 * Star Wars API interface for making calls.
 */
public interface StarWarsEndPoint {

    @GET("api/")
    void getRootUrls(Callback<Root> callback);

    @GET("/api/people/")
    Call<SWModelList<People>> getAllPeople(@Query("page") int page);

    @GET("/api/people/{id}/")
    Call<People> getPeople(@Path("id") int peopleId);

    @GET("/api/films/")
    Call<SWModelList<Film>> getAllFilms(@Query("page") int page);

    @GET("/api/films/{id}/")
    Call<Film> getFilm(@Path("id") int filmId);

    @GET("/api/starships")
    Call<SWModelList<Starship>> getAllStarships(@Query("page") int page);

    @GET("/api/starships/{id}/")
    Call<Starship> getStarship(@Path("id") int starshipId);

    @GET("/api/vehicles/")
    Call<SWModelList<Vehicle>> getAllVehicles(@Query("page") int page);

    @GET("/api/vehicles/{id}/")
    Call<Vehicle> getVehicle(@Path("id") int vehicleId);

    @GET("/api/species/")
    Call<SWModelList<Species>> getAllSpecies(@Query("page") int page);

    @GET("/api/species/{id}/")
    Call<Species> getSpecies(@Path("id") int speciesId);

    @GET("/api/planets/")
    Call<SWModelList<Planet>> getAllPlanets(@Query("page") int page);

    @GET("/api/planets/{id}/")
    Call<Planet> getPlanet(@Path("id") int planetId);

    @GET("/api/people/")
    Call<SWModelList<People>> searchPeople(@Query("search") String query);

    @GET("/api/planets/")
    Call<SWModelList<Planet>> searchPlanets(@Query("search") String encodedQuery);

    @GET("/api/films/")
    Call<SWModelList<Film>> searchFilms(@Query("search") String encodedQuery);

    @GET("/api/starships")
    Call<SWModelList<Starship>> searchStarship(@Query("search") String encodedQuery);
}
