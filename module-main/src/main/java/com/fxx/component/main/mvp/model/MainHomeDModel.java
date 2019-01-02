package com.fxx.component.main.mvp.model;

import android.app.Application;

import com.fxx.component.main.mvp.model.api.service.MainService;
import com.fxx.component.main.mvp.model.entity.FindNewsBean;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.fxx.component.main.mvp.contract.MainHomeDContract;

import java.util.HashMap;

import io.reactivex.Observable;


@FragmentScope
public class MainHomeDModel extends BaseModel implements MainHomeDContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MainHomeDModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<FindNewsBean> getFindNews(HashMap<String, Object> map) {
        return mRepositoryManager.obtainRetrofitService(MainService.class).getInformationNew(map);
    }
}