package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainHomeEContract;
import com.fxx.component.main.mvp.model.MainHomeEModel;


@Module
public class MainHomeEModule {
    private MainHomeEContract.View view;

    /**
     * 构建MainHomeEModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainHomeEModule(MainHomeEContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MainHomeEContract.View provideMainHomeEView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MainHomeEContract.Model provideMainHomeEModel(MainHomeEModel model) {
        return model;
    }
}