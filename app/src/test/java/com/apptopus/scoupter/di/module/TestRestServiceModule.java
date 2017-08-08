package com.apptopus.scoupter.di.module;

import com.apptopus.scoupter.rest.RestService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class TestRestServiceModule {
    private Retrofit retrofit;

    public TestRestServiceModule() {
    }

    public TestRestServiceModule(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Provides
    public Retrofit provideRetrofit() {
        return this.retrofit;
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
