package com.fxx.component.appcomponent.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fxx.component.commonsdk.core.RouterHub;
import com.fxx.component.commonsdk.utils.Constant;
import com.fxx.component.commonsdk.utils.Utils;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.fxx.component.appcomponent.di.component.DaggerSplashComponent;
import com.fxx.component.appcomponent.di.module.SplashModule;
import com.fxx.component.appcomponent.mvp.contract.SplashContract;
import com.fxx.component.appcomponent.mvp.presenter.SplashPresenter;

import com.fxx.component.appcomponent.R;
import com.jess.arms.utils.DataHelper;
import com.pgyersdk.crash.PgyCrashManager;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {
    private ImageView imageView;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerSplashComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .splashModule(new SplashModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏

        return R.layout.activity_splash; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
        PgyCrashManager.register(); //推荐使用

        imageView = (ImageView) findViewById(R.id.iv_splash);
        Glide.with(this).load(R.drawable.public_icon_splash).apply(new RequestOptions().centerCrop()).into(imageView);

        // TODO: 2018/11/15  is_login
        // TODO: 2018/11/15  is_guide


        Observable.timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (TextUtils.isEmpty(DataHelper.getStringSF(SplashActivity.this, Constant.COMMON_TOKEN))){
                            Utils.navigation(SplashActivity.this, RouterHub.MAIN_MAINHOMEACTIVITY);
                        }else {
                            Utils.navigation(SplashActivity.this, RouterHub.MAIN_MAINHOMEACTIVITY);
                        }
                        finish();
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }
}
