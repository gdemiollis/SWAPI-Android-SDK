package com.swapi.http;

import com.google.gson.Gson;
import com.swapi.model.SWEntity;
import com.swapi.model.SWModelList;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class BaseApi<E extends SWEntity> {

    private final Retrofit retrofit;
    protected final StarWarsEndPoint starWarsEndPoint;
    private final Gson gson;
    public static final String BASE_URL = "http://swapi.co/";

    public BaseApi() {
        gson = new Gson();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(StarWarsOkClient.newInstance())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        starWarsEndPoint = retrofit.create(StarWarsEndPoint.class);
    }

    protected List<E> list(Call<SWModelList<E>> call) throws IOException {
        Response<SWModelList<E>> response = call.execute();
        if (response.isSuccessful()) {
            return response.body().results;
        }
        throw new IOException("Error " + response.code() + " : " + response.message());
    }
}
