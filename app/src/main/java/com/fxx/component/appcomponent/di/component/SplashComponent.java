package com.fxx.component.appcomponent.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.appcomponent.di.module.SplashModule;

import com.jess.arms.di.scope.ActivityScope;
import com.fxx.component.appcomponent.mvp.ui.activity.SplashActivity;

@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}