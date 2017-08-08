package com.apptopus.scoupter.presenter;

import com.apptopus.scoupter.di.component.DaggerRestServiceComponent;
import com.apptopus.scoupter.model.ScooterData;
import com.apptopus.scoupter.model.ScoupterResponse;
import com.apptopus.scoupter.rest.RestService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoupterPresenter implements ScoupterActivityContract.Operations {

    @Inject
    RestService restService;

    ScoupterActivityContract.View view;

    public ScoupterPresenter(ScoupterActivityContract.View view) {
        DaggerRestServiceComponent.builder().build().inject(this);
        this.view = view;
    }

    @Override
    public void getScoters() {
        restService.getScoupterService().scooters().enqueue(new Callback<ScoupterResponse<ScooterData>>() {
            @Override

            public void onResponse(Call<ScoupterResponse<ScooterData>> call, Response<ScoupterResponse<ScooterData>> response) {
                view.hideProgressSpinner();
                if (response.isSuccessful()) {
                    if (response.body().getMeta().getStatus() == 0)
                        view.updateMapMarkers(response.body().getData().getScooters());
                }

            }

            @Override
            public void onFailure(Call<ScoupterResponse<ScooterData>> call, Throwable t) {
                view.hideProgressSpinner();
            }
        });

    }
}
