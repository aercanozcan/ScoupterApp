package com.apptopus.scoupter.di.component;

import com.apptopus.scoupter.di.module.RestServiceModule;
import com.apptopus.scoupter.di.module.ScoupterPresenterModule;
import com.apptopus.scoupter.presenter.ScoupterPresenter;
import com.apptopus.scoupter.rest.RestService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RestServiceModule.class, ScoupterPresenterModule.class})

public interface RestServiceComponent {

    void inject(RestService restService);

    void inject(ScoupterPresenter presenter);
}
