package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainCommonWebViewModule;

import com.jess.arms.di.scope.ActivityScope;
import com.fxx.component.main.mvp.ui.activity.MainCommonWebViewActivity;

@ActivityScope
@Component(modules = MainCommonWebViewModule.class, dependencies = AppComponent.class)
public interface MainCommonWebViewComponent {
    void inject(MainCommonWebViewActivity activity);
}