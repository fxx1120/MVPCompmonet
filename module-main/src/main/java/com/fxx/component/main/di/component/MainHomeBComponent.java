package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainHomeBModule;

import com.jess.arms.di.scope.FragmentScope;
import com.fxx.component.main.mvp.ui.fragment.MainHomeBFragment;

@FragmentScope
@Component(modules = MainHomeBModule.class, dependencies = AppComponent.class)
public interface MainHomeBComponent {
    void inject(MainHomeBFragment fragment);
}