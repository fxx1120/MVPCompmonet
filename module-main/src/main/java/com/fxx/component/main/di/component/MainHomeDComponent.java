package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainHomeDModule;

import com.jess.arms.di.scope.FragmentScope;
import com.fxx.component.main.mvp.ui.fragment.MainHomeDFragment;

@FragmentScope
@Component(modules = MainHomeDModule.class, dependencies = AppComponent.class)
public interface MainHomeDComponent {
    void inject(MainHomeDFragment fragment);
}