package com.apptopus.scoupter.di.module;

import com.apptopus.scoupter.presenter.ScoupterActivityContract;
import com.apptopus.scoupter.presenter.ScoupterPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ScoupterPresenterModule {

    private ScoupterActivityContract.View view;

    public ScoupterPresenterModule (){}//dagger 2 needs default constructor to generate

    public ScoupterPresenterModule (ScoupterActivityContract.View view){
        this.view = view;
    }

    @Provides
    public ScoupterActivityContract.View provideView(){
        return view;
    }

    @Provides
    public ScoupterPresenter providePresenter(){
        return new ScoupterPresenter(view);
    }
}
