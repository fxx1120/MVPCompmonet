package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainHomeDContract;
import com.fxx.component.main.mvp.model.MainHomeDModel;


@Module
public class MainHomeDModule {
    private MainHomeDContract.View view;

    /**
     * 构建MainHomeDModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainHomeDModule(MainHomeDContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MainHomeDContract.View provideMainHomeDView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MainHomeDContract.Model provideMainHomeDModel(MainHomeDModel model) {
        return model;
    }
}