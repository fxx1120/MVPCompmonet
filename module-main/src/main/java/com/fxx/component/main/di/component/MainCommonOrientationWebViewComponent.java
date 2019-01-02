package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainCommonOrientationWebViewModule;

import com.jess.arms.di.scope.ActivityScope;
import com.fxx.component.main.mvp.ui.activity.MainCommonOrientationWebViewActivity;

@ActivityScope
@Component(modules = MainCommonOrientationWebViewModule.class, dependencies = AppComponent.class)
public interface MainCommonOrientationWebViewComponent {
    void inject(MainCommonOrientationWebViewActivity activity);
}