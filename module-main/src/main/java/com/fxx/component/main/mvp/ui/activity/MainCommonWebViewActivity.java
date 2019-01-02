package com.fxx.component.main.mvp.ui.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.fxx.component.commonsdk.utils.Constant;
import com.fxx.component.main.R;
import com.fxx.component.main.R2;
import com.fxx.component.main.app.Conts;
import com.fxx.component.main.di.component.DaggerMainCommonWebViewComponent;
import com.fxx.component.main.di.module.MainCommonWebViewModule;
import com.fxx.component.main.mvp.contract.MainCommonWebViewContract;
import com.fxx.component.main.mvp.model.entity.WebUserInfoBean;
import com.fxx.component.main.mvp.presenter.MainCommonWebViewPresenter;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DataHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainCommonWebViewActivity extends BaseActivity<MainCommonWebViewPresenter> implements MainCommonWebViewContract.View {

    @BindView(R2.id.webView)
    BridgeWebView webView;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R2.id.public_toolbar_title)
    TextView publicToolbarTitle;
//    private String assets_url = "file:///android_asset/index.html";
    private String net_url = "http://192.168.0.141:3000/";
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainCommonWebViewComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainCommonWebViewModule(new MainCommonWebViewModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.main_activity_main_common_web_view; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        publicToolbarTitle.setText(getIntent().getStringExtra(Conts.MAIN_TITLE));
        net_url = net_url+getIntent().getStringExtra(Conts.MAIN_NAME)+".html";
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                webView.loadUrl(net_url);
//                webView.callHandler("redirect", getIntent().getStringExtra(Conts.MAIN_DATA), new CallBackFunction() {
//                    @Override
//                    public void onCallBack(String data) {
//
//                    }
//                });
                refreshLayout.finishRefresh();
            }
        });
        refreshLayout.setEnableLoadMore(false);
        webView.setDefaultHandler(new DefaultHandler());


        webView.setWebViewClient(new BridgeWebViewClient(webView) {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
//                ArmsUtils.snackbarText("onPageStarted");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                webView.callHandler("redirect", getIntent().getStringExtra(Conts.MAIN_DATA), new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {

                    }
                });

                WebUserInfoBean userInfoBean = new WebUserInfoBean();
                userInfoBean.setAccess_token(DataHelper.getStringSF(MainCommonWebViewActivity.this, Constant.COMMON_TOKEN));
                userInfoBean.setExtend_id(DataHelper.getStringSF(MainCommonWebViewActivity.this, Constant.COMMON_IDENTITY_ID));
                userInfoBean.setType(DataHelper.getStringSF(MainCommonWebViewActivity.this, Constant.COMMON_IDENTITY));
                Log.i(TAG, "onPageFinished: " + new Gson().toJson(userInfoBean));
                webView.callHandler("getUserInfo", new Gson().toJson(userInfoBean), new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {

                    }
                });


            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                ArmsUtils.snackbarText("" + errorCode);
            }


        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

        });

        webView.loadUrl(net_url);

        webView.registerHandler("openWindow", new BridgeHandler() {

            @Override
            public void handler(String data, CallBackFunction function) {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
