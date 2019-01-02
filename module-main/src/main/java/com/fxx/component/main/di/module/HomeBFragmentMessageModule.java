package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.HomeBFragmentMessageContract;
import com.fxx.component.main.mvp.model.HomeBFragmentMessageModel;


@Module
public class HomeBFragmentMessageModule {
    private HomeBFragmentMessageContract.View view;

    /**
     * 构建HomeBFragmentMessageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HomeBFragmentMessageModule(HomeBFragmentMessageContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HomeBFragmentMessageContract.View provideHomeBFragmentMessageView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    HomeBFragmentMessageContract.Model provideHomeBFragmentMessageModel(HomeBFragmentMessageModel model) {
        return model;
    }
}