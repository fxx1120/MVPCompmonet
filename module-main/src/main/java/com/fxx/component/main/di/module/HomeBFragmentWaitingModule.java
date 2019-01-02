package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.HomeBFragmentWaitingContract;
import com.fxx.component.main.mvp.model.HomeBFragmentWaitingModel;


@Module
public class HomeBFragmentWaitingModule {
    private HomeBFragmentWaitingContract.View view;

    /**
     * 构建HomeBFragmentWaitingModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HomeBFragmentWaitingModule(HomeBFragmentWaitingContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HomeBFragmentWaitingContract.View provideHomeBFragmentWaitingView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    HomeBFragmentWaitingContract.Model provideHomeBFragmentWaitingModel(HomeBFragmentWaitingModel model) {
        return model;
    }
}