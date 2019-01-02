package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainHomeAContract;
import com.fxx.component.main.mvp.model.MainHomeAModel;


@Module
public class MainHomeAModule {
    private MainHomeAContract.View view;

    /**
     * 构建MainHomeAModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainHomeAModule(MainHomeAContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MainHomeAContract.View provideMainHomeAView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MainHomeAContract.Model provideMainHomeAModel(MainHomeAModel model) {
        return model;
    }
}