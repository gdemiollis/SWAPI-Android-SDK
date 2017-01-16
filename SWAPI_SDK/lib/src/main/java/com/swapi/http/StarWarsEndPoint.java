package com.swapi.http;

import com.swapi.models.Film;
import com.swapi.models.People;
import com.swapi.models.Planet;
import com.swapi.models.Root;
import com.swapi.models.SWModelList;
import com.swapi.models.Species;
import com.swapi.models.Starship;
import com.swapi.models.Vehicle;

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
    Call<Film> getAllFilms(@Query("page") int page);

    @GET("/api/films/{id}/")
    Call<SWModelList<Film>> getFilm(@Path("id") int filmId);

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
    Call<SWModelList<Planet>> getAllPlanets();

    @GET("/api/planets/{id}/")
    Call<Planet> getPlanet(@Path("id") int planetId);

}
