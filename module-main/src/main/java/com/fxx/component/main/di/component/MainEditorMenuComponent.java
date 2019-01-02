package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainEditorMenuModule;

import com.jess.arms.di.scope.ActivityScope;
import com.fxx.component.main.mvp.ui.activity.MainEditorMenuActivity;

@ActivityScope
@Component(modules = MainEditorMenuModule.class, dependencies = AppComponent.class)
public interface MainEditorMenuComponent {
    void inject(MainEditorMenuActivity activity);
}