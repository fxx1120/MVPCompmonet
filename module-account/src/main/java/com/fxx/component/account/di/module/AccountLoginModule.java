package com.fxx.component.account.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.account.mvp.contract.AccountLoginContract;
import com.fxx.component.account.mvp.model.AccountLoginModel;


@Module
public class AccountLoginModule {
    private AccountLoginContract.View view;

    /**
     * 构建AccountLoginModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AccountLoginModule(AccountLoginContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    AccountLoginContract.View provideAccountLoginView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    AccountLoginContract.Model provideAccountLoginModel(AccountLoginModel model) {
        return model;
    }
}