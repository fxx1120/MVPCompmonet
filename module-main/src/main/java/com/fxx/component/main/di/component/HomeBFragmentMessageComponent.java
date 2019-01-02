package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.HomeBFragmentMessageModule;

import com.jess.arms.di.scope.FragmentScope;
import com.fxx.component.main.mvp.ui.fragment.HomeBFragmentMessageFragment;

@FragmentScope
@Component(modules = HomeBFragmentMessageModule.class, dependencies = AppComponent.class)
public interface HomeBFragmentMessageComponent {
    void inject(HomeBFragmentMessageFragment fragment);
}