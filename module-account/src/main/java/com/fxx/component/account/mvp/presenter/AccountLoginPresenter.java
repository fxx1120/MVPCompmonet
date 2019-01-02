package com.fxx.component.account.mvp.presenter;

import android.app.Application;

import com.fxx.component.account.mvp.model.entity.LoginToken;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

import javax.inject.Inject;

import com.fxx.component.account.mvp.contract.AccountLoginContract;
import com.jess.arms.utils.RxLifecycleUtils;


@ActivityScope
public class AccountLoginPresenter extends BasePresenter<AccountLoginContract.Model, AccountLoginContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public AccountLoginPresenter(AccountLoginContract.Model model, AccountLoginContract.View rootView) {
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


    public void requestLogin(String mobile,String password) {
        mModel.getLogin(mobile, password,"app")
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(2, 1))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用RXlifecycle,使subscription和activity一起销毁
                .doAfterTerminate(() -> {
                    mRootView.hideLoading();
                })
                .subscribe(new ErrorHandleSubscriber<LoginToken>(mErrorHandler) {
                    @Override
                    public void onNext(LoginToken token) {
                        mRootView.onShowLoginResult(token);
                        mRootView.hideLoading();
                    }
                });
    }
}
