package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.HomeBFragmentWaitingModule;

import com.jess.arms.di.scope.FragmentScope;
import com.fxx.component.main.mvp.ui.fragment.HomeBFragmentWaitingFragment;

@FragmentScope
@Component(modules = HomeBFragmentWaitingModule.class, dependencies = AppComponent.class)
public interface HomeBFragmentWaitingComponent {
    void inject(HomeBFragmentWaitingFragment fragment);
}