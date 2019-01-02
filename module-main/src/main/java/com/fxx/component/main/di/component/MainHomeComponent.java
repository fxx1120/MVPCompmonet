package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainHomeModule;

import com.jess.arms.di.scope.ActivityScope;
import com.fxx.component.main.mvp.ui.activity.MainHomeActivity;

@ActivityScope
@Component(modules = MainHomeModule.class, dependencies = AppComponent.class)
public interface MainHomeComponent {
    void inject(MainHomeActivity activity);
}