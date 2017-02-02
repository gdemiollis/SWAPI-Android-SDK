package com.swapi.http;

import com.swapi.model.SWModelList;
import com.swapi.model.Starship;
import retrofit2.Call;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class SpaceshipApi extends BaseApi<Starship> {

    public List<Starship> listSpaceship() throws IOException {
        Call<SWModelList<Starship>> call = starWarsEndPoint.getAllStarships(1);
        return list(call);
    }

    public List<Starship> searchFilms(String query) throws IOException {
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        Call<SWModelList<Starship>> call = starWarsEndPoint.searchStarship(encodedQuery);
        return list(call);
    }
}
