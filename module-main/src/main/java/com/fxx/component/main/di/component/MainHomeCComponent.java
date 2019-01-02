package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainHomeCModule;

import com.jess.arms.di.scope.FragmentScope;
import com.fxx.component.main.mvp.ui.fragment.MainHomeCFragment;

@FragmentScope
@Component(modules = MainHomeCModule.class, dependencies = AppComponent.class)
public interface MainHomeCComponent {
    void inject(MainHomeCFragment fragment);
}