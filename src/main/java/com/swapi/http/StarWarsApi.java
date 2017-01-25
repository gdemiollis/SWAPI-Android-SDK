package com.swapi.http;

import com.google.gson.Gson;
import com.swapi.models.Film;
import com.swapi.models.Planet;
import com.swapi.models.SWModelList;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarWarsApi extends BaseApi {

    private final Retrofit retrofit;
    private final StarWarsEndPoint starWarsEndPoint;
    private final Gson gson;
    public static final String BASE_URL = "http://swapi.co/";

    public StarWarsApi() {
        gson = new Gson();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(StarWarsOkClient.newInstance())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        starWarsEndPoint = retrofit.create(StarWarsEndPoint.class);
    }

    public List<Planet> listPlanets() throws IOException {
        Call<SWModelList<Planet>> call = starWarsEndPoint.getAllPlanets(1);
        Response<SWModelList<Planet>> response = call.execute();
        if (response.isSuccessful()) {
            return response.body().results;
        }
        throw new RuntimeException("Erreur lors de la récupération dela liste des planètes");
    }

    public List<Film> listFilms() throws IOException {
        Call<SWModelList<Film>> call = starWarsEndPoint.getAllFilms(1);
        Response<SWModelList<Film>> response = call.execute();
        if (response.isSuccessful()) {
            return response.body().results;
        }
        throw new RuntimeException("Erreur lors de la récupération dela liste des planètes");
    }
}
