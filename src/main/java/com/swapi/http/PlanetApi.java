package com.swapi.http;

import com.swapi.model.Planet;
import com.swapi.model.SWModelList;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import retrofit2.Call;

public class PlanetApi extends BaseApi<Planet> {


    public List<Planet> listPlanets() throws IOException {
        Call<SWModelList<Planet>> call = starWarsEndPoint.getAllPlanets(1);
        return list(call);
    }

    public List<Planet> searchPlanet(String query) throws IOException {
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        Call<SWModelList<Planet>> call = starWarsEndPoint.searchPlanets(encodedQuery);
        return list(call);
    }
}
