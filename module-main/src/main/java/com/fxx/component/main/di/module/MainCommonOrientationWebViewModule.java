package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainCommonOrientationWebViewContract;
import com.fxx.component.main.mvp.model.MainCommonOrientationWebViewModel;


@Module
public class MainCommonOrientationWebViewModule {
    private MainCommonOrientationWebViewContract.View view;

    /**
     * 构建MainCommonOrientationWebViewModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainCommonOrientationWebViewModule(MainCommonOrientationWebViewContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainCommonOrientationWebViewContract.View provideMainCommonOrientationWebViewView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainCommonOrientationWebViewContract.Model provideMainCommonOrientationWebViewModel(MainCommonOrientationWebViewModel model) {
        return model;
    }
}