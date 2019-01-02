package com.fxx.component.main.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.fxx.component.commonsdk.utils.Constant;
import com.fxx.component.main.R;
import com.fxx.component.main.R2;
import com.fxx.component.main.app.Conts;
import com.fxx.component.main.di.component.DaggerMainEditorMenuComponent;
import com.fxx.component.main.di.module.MainEditorMenuModule;
import com.fxx.component.main.mvp.contract.MainEditorMenuContract;
import com.fxx.component.main.mvp.model.entity.ADataModelBean;
import com.fxx.component.main.mvp.model.entity.WebUserInfoBean;
import com.fxx.component.main.mvp.presenter.MainEditorMenuPresenter;
import com.fxx.component.main.mvp.ui.manager.RolePermissionManager;
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
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainEditorMenuActivity extends BaseActivity<MainEditorMenuPresenter> implements MainEditorMenuContract.View {

    @BindView(R2.id.public_toolbar_back)
    AutoRelativeLayout publicToolbarBack;
    @BindView(R2.id.public_toolbar_title)
    TextView publicToolbarTitle;
    @BindView(R2.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R2.id.webView)
    BridgeWebView webView;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
//    private String assets_url = "file:///android_asset/index.html";
    private String net_url = "http://192.168.0.141:3000/ComponentLibrary.html";

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainEditorMenuComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainEditorMenuModule(new MainEditorMenuModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.main_activity_main_editor_menu; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        publicToolbarTitle.setText("看板");
        toolbarRight.setText("保存");
        toolbarRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(200);
                finish();
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                webView.loadUrl(net_url);
//                HashMap map = new HashMap();
//                map.put("name","ComponentLibrary");
//                webView.callHandler("redirect",new Gson().toJson(map), new CallBackFunction() {
//                    @Override
//                    public void onCallBack(String data) {
//
//                    }
//                });
                refreshLayout.finishRefresh();
            }
        });
        refreshLayout.setEnableLoadMore(false);

        Log.i(TAG, "initData: " + RolePermissionManager.rolePermission(this, "consulting-upcoming"));
        Log.i(TAG, "initData: " + RolePermissionManager.rolePermission(this, "consulting-execute-amount"));

        webView.setDefaultHandler(new DefaultHandler());
        webView.setWebContentsDebuggingEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setWebViewClient(new BridgeWebViewClient(webView) {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
//                ArmsUtils.snackbarText("onPageStarted");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


                HashMap map = new HashMap();
                map.put("name","ComponentLibrary");
                webView.callHandler("redirect",new Gson().toJson(map), new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {

                    }
                });

                WebUserInfoBean userInfoBean = new WebUserInfoBean();
                userInfoBean.setAccess_token(DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_TOKEN));
                userInfoBean.setExtend_id(DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY_ID));
                userInfoBean.setType(DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY));
                Log.i(TAG, "onPageFinished: " + new Gson().toJson(userInfoBean));
                webView.callHandler("getUserInfo", new Gson().toJson(userInfoBean), new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {

                    }
                });

                String menu = "";
                if (DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY).equals("industrial_park")) {
                    menu = Conts.STR_MENU_PARK;
                } else {
//                    menu = Conts.STR_MENU_COU;
                    //根据角色判断
                    menu = getRoleMenu();
                }
                Log.i(TAG, "onPageFinished: " + menu);
                webView.callHandler("getAllLibrary", menu, new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {

                    }
                });

                menu = "";
                if (DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY).equals("industrial_park")) {
                    if (TextUtils.isEmpty(DataHelper.getStringSF(MainEditorMenuActivity.this, Conts.MAIN_MENU+DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY)))) {
                        menu = Conts.STR_MENU_PARK;
                    } else {
                        menu = DataHelper.getStringSF(MainEditorMenuActivity.this, Conts.MAIN_MENU + DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY));
                    }
                } else {
                    if (TextUtils.isEmpty(DataHelper.getStringSF(MainEditorMenuActivity.this, Conts.MAIN_MENU+DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY)))) {
                        menu = getRoleMenu();
                    } else {
                        menu = DataHelper.getStringSF(MainEditorMenuActivity.this, Conts.MAIN_MENU + DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY));
                    }
                }


                Log.i(TAG, "onPageFinished: " + menu);

                webView.callHandler("getLibrary", menu, new CallBackFunction() {
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

        webView.registerHandler("setLibrary", new BridgeHandler() {

            @Override
            public void handler(String data, CallBackFunction function) {
                Log.i(TAG, "handler: "+data);
                DataHelper.setStringSF(MainEditorMenuActivity.this, Conts.MAIN_MENU + DataHelper.getStringSF(MainEditorMenuActivity.this, Constant.COMMON_IDENTITY), data);
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


    public String getRoleMenu(){
        List<ADataModelBean> list = new ArrayList<>();

        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-upcoming")) {
            ADataModelBean aDataModelBean = new ADataModelBean("待办事项", "backlog");
            list.add(aDataModelBean);
        }
        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-operate-data")) {
            ADataModelBean aDataModelBean = new ADataModelBean("经营数据", "manage-data");
            list.add(aDataModelBean);
        }
        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-year-performance")) {
            ADataModelBean aDataModelBean = new ADataModelBean("年度业绩", "annual-data");
            list.add(aDataModelBean);
        }

        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-manage-contact")) {
            ADataModelBean aDataModelBean = new ADataModelBean("合同管理", "contract-manage");
            list.add(aDataModelBean);
        }

        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-manage-project")) {
            ADataModelBean aDataModelBean = new ADataModelBean("项目管理", "project-manage");
            list.add(aDataModelBean);
        }

        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-execute-amount")) {
            ADataModelBean aDataModelBean = new ADataModelBean("年度合同额", "year-contract-money");
            list.add(aDataModelBean);
        }
        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-invoice-amount")) {
            ADataModelBean aDataModelBean = new ADataModelBean("年度开票金额", "year-bill-money");
            list.add(aDataModelBean);
        }
        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-sign-invoice-amount")) {
            ADataModelBean aDataModelBean = new ADataModelBean("年度签单开票额", "year-sign-bill-money");
            list.add(aDataModelBean);
        }


        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-user-performance-one")) {
            ADataModelBean aDataModelBean = new ADataModelBean("个人业绩排行", "consulting-user-performance-one");
            list.add(aDataModelBean);
        }

        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-user-performance-two")) {
            ADataModelBean aDataModelBean = new ADataModelBean("个人跟单排行", "consulting-user-performance-two");
            list.add(aDataModelBean);
        }

        if (true||RolePermissionManager.rolePermission(MainEditorMenuActivity.this, "consulting-group-performance")) {
            ADataModelBean aDataModelBean = new ADataModelBean("小组业绩排行", "group-performance");
            list.add(aDataModelBean);
        }

        return new Gson().toJson(list);
    }


    @Override
    public void onBackPressed() {
        Log.i(TAG, "onBackPressed");
        // super.onBackPressed();//注释掉这行,back键不退出activity
        setResult(200);
        finish();

    }

}
