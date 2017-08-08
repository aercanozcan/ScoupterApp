package com.apptopus.scoupter.rest;


import com.apptopus.scoupter.di.component.DaggerRestServiceComponent;
import com.apptopus.scoupter.model.ScooterData;
import com.apptopus.scoupter.model.ScoupterResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class RestService {

    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String ACTION = "/scooters.json";

    @Inject
    Retrofit retrofit;

    @Inject
    ScoupterService scoupterService;

    public RestService() {
        DaggerRestServiceComponent.builder().build().inject(this);
    }

    public RestService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public ScoupterService getScoupterService() {
        return scoupterService;
    }

    public interface ScoupterService {
        @GET(API + VERSION + ACTION)
        Call<ScoupterResponse<ScooterData>> scooters();
    }


}
