package com.swapi.http;

import com.swapi.model.Film;
import com.swapi.model.SWModelList;
import retrofit2.Call;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class FilmApi extends BaseApi<Film> {

    public List<Film> listFilms() throws IOException {
        Call<SWModelList<Film>> call = starWarsEndPoint.getAllFilms(1);
        return list(call);
    }

    public List<Film> searchFilms(String query) throws IOException {
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        Call<SWModelList<Film>> call = starWarsEndPoint.searchFilms(encodedQuery);
        return list(call);
    }
}
