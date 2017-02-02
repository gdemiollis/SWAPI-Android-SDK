package com.swapi.http;

import com.swapi.model.People;
import com.swapi.model.SWModelList;
import retrofit2.Call;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class PeopleApi extends BaseApi<People> {

    public List<People> listPeople() throws IOException {
        Call<SWModelList<People>> call = starWarsEndPoint.getAllPeople(1);
        return list(call);
    }

    public List<People> searchPeople(String query) throws IOException {
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        Call<SWModelList<People>> call = starWarsEndPoint.searchPeople(encodedQuery);
        return list(call);
    }
}
