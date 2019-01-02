package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainHomeBContract;
import com.fxx.component.main.mvp.model.MainHomeBModel;


@Module
public class MainHomeBModule {
    private MainHomeBContract.View view;

    /**
     * 构建MainHomeBModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainHomeBModule(MainHomeBContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MainHomeBContract.View provideMainHomeBView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MainHomeBContract.Model provideMainHomeBModel(MainHomeBModel model) {
        return model;
    }
}