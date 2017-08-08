package com.apptopus.scoupter.di.component;

import com.apptopus.scoupter.ScoupterActivity;
import com.apptopus.scoupter.di.module.ScoupterPresenterModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = ScoupterPresenterModule.class)
public interface ScoupterPresenterComponent {
     void inject(ScoupterActivity activity);
}
