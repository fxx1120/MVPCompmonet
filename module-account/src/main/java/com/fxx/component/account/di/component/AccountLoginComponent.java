package com.fxx.component.account.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.account.di.module.AccountLoginModule;

import com.jess.arms.di.scope.ActivityScope;
import com.fxx.component.account.mvp.ui.activity.AccountLoginActivity;

@ActivityScope
@Component(modules = AccountLoginModule.class, dependencies = AppComponent.class)
public interface AccountLoginComponent {
    void inject(AccountLoginActivity activity);
}