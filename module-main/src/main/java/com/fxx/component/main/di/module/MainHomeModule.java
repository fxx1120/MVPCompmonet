package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainHomeContract;
import com.fxx.component.main.mvp.model.MainHomeModel;


@Module
public class MainHomeModule {
    private MainHomeContract.View view;

    /**
     * 构建MainHomeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainHomeModule(MainHomeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainHomeContract.View provideMainHomeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainHomeContract.Model provideMainHomeModel(MainHomeModel model) {
        return model;
    }
}