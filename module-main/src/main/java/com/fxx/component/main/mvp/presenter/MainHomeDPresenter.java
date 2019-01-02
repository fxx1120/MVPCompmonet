package com.fxx.component.main.mvp.presenter;

import android.app.Application;

import com.fxx.component.main.mvp.model.entity.FindNewsBean;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

import javax.inject.Inject;

import com.fxx.component.main.mvp.contract.MainHomeDContract;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.HashMap;


@FragmentScope
public class MainHomeDPresenter extends BasePresenter<MainHomeDContract.Model, MainHomeDContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public MainHomeDPresenter(MainHomeDContract.Model model, MainHomeDContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void requestFindNews(HashMap<String, Object> map) {
        mModel.getFindNews(map)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用RXlifecycle,使subscription和activity一起销毁
                .doAfterTerminate(() -> {
                    mRootView.hideLoading();
                })
                .subscribe(new ErrorHandleSubscriber<FindNewsBean>(mErrorHandler) {
                    @Override
                    public void onNext(FindNewsBean data) {
                        mRootView.onShowResult(data);
                    }
                });
    }
}
