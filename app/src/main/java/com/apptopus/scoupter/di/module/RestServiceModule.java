package com.apptopus.scoupter.di.module;

import com.apptopus.scoupter.rest.RestService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RestServiceModule {

    private Retrofit retrofit;
    public static String END_POINT = "https://app.joincoup.com";

    public RestServiceModule() {
    }

    public RestServiceModule(Retrofit retrofit, String endPoint) {
        this.retrofit = retrofit;
        this.END_POINT = endPoint;
    }

    @Provides
    public Retrofit provideRetrofit(@Named("endPoint") String endPoint) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return this.retrofit;
    }

    @Provides
    @Named("endPoint")
    public String provideEndpoint() {
        return END_POINT;
    }

    @Provides
    @Singleton
    public RestService.ScoupterService provideScoupterService() {
        return retrofit.create(RestService.ScoupterService.class);
    }

    @Provides
    @Singleton
    public RestService provideRestService() {
        return new RestService();
    }

}
