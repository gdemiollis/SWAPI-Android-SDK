package com.swapi.sw;

import android.os.Build;

import com.google.gson.Gson;
import com.swapi.APIConstants;
import com.swapi.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Oleur on 22/12/2014.
 * The Star Wars Api class
 */
public class StarWarsApi {

    private final Retrofit retrofit;
    private StarWars mSwApi;
    private static StarWarsApi sInstance;

    private StarWarsApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .client(StarWarsOkClient.newInstance())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        retrofit.create(StarWars.class);
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

    public static void init() {
        sInstance = new StarWarsApi();
    }

    public static StarWars getApi() {
        return sInstance.mSwApi;
    }

    public void setApi(StarWars starWarsApi) {
        sInstance.mSwApi = starWarsApi;
    }
}
