package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainEditorMenuContract;
import com.fxx.component.main.mvp.model.MainEditorMenuModel;


@Module
public class MainEditorMenuModule {
    private MainEditorMenuContract.View view;

    /**
     * 构建MainEditorMenuModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainEditorMenuModule(MainEditorMenuContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainEditorMenuContract.View provideMainEditorMenuView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainEditorMenuContract.Model provideMainEditorMenuModel(MainEditorMenuModel model) {
        return model;
    }
}