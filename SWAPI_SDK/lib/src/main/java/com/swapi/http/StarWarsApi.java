package com.swapi.http;

import android.os.Build;

import com.google.gson.Gson;
import com.swapi.BuildConfig;
import com.swapi.models.Planet;
import com.swapi.models.SWModelList;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarWarsApi {

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

    private static Interceptor getUserAgentHeader() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("User-Agent", "Android " + Build.VERSION.RELEASE + "; Morning " + BuildConfig.VERSION_NAME)
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        };
    }

    public List<Planet> listPlanets() throws IOException {
        Call<SWModelList<Planet>> call = starWarsEndPoint.getAllPlanets();
        retrofit2.Response<SWModelList<Planet>> response = call.execute();
        if (response.isSuccessful()) {
            return response.body().results;
        }
        throw new RuntimeException("Erreur lors de la récupération dela liste des planètes");
    }
}
