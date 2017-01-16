package com.swapi.http;

import android.os.Build;

import com.swapi.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StarWarsOkClient {

    public StarWarsOkClient() {
        super();
    }

    public static OkHttpClient newInstance() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(getUserAgentHeader())
                .build();
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
}
