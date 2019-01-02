package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainHomeEModule;

import com.jess.arms.di.scope.FragmentScope;
import com.fxx.component.main.mvp.ui.fragment.MainHomeEFragment;

@FragmentScope
@Component(modules = MainHomeEModule.class, dependencies = AppComponent.class)
public interface MainHomeEComponent {
    void inject(MainHomeEFragment fragment);
}