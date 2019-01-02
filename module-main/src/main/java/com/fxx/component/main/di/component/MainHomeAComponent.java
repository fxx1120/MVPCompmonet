package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainHomeAModule;

import com.jess.arms.di.scope.FragmentScope;
import com.fxx.component.main.mvp.ui.fragment.MainHomeAFragment;

@FragmentScope
@Component(modules = MainHomeAModule.class, dependencies = AppComponent.class)
public interface MainHomeAComponent {
    void inject(MainHomeAFragment fragment);
}