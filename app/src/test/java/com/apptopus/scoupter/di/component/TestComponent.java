package com.apptopus.scoupter.di.component;


import com.apptopus.scoupter.di.module.TestRestServiceModule;
import com.apptopus.scoupter.rest.RestServiceTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestRestServiceModule.class)
public interface TestComponent {
        void inject(RestServiceTest restServiceTest);
}
