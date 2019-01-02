package com.fxx.component.account.mvp.model;

import android.app.Application;

import com.fxx.component.account.mvp.model.api.service.AccountService;
import com.fxx.component.account.mvp.model.entity.LoginToken;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.fxx.component.account.mvp.contract.AccountLoginContract;

import io.reactivex.Observable;


@ActivityScope
public class AccountLoginModel extends BaseModel implements AccountLoginContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public AccountLoginModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }


    @Override
    public Observable<LoginToken> getLogin(String mobile, String pasword, String source) {
        Observable<LoginToken> loginTokenObservable = mRepositoryManager.obtainRetrofitService(AccountService.class)
                .getLogin( mobile, pasword,source);
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return loginTokenObservable;
    }
}