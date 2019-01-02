package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainHomeCContract;
import com.fxx.component.main.mvp.model.MainHomeCModel;


@Module
public class MainHomeCModule {
    private MainHomeCContract.View view;

    /**
     * 构建MainHomeCModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainHomeCModule(MainHomeCContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MainHomeCContract.View provideMainHomeCView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MainHomeCContract.Model provideMainHomeCModel(MainHomeCModel model) {
        return model;
    }
}