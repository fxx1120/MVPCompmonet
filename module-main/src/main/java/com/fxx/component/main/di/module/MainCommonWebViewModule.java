package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainCommonWebViewContract;
import com.fxx.component.main.mvp.model.MainCommonWebViewModel;


@Module
public class MainCommonWebViewModule {
    private MainCommonWebViewContract.View view;

    /**
     * 构建MainCommonWebViewModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainCommonWebViewModule(MainCommonWebViewContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainCommonWebViewContract.View provideMainCommonWebViewView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainCommonWebViewContract.Model provideMainCommonWebViewModel(MainCommonWebViewModel model) {
        return model;
    }
}