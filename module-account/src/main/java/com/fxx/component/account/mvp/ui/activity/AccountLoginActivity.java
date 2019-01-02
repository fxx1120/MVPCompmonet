package com.fxx.component.account.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fxx.component.account.R;
import com.fxx.component.account.R2;
import com.fxx.component.account.app.Conts;
import com.fxx.component.account.di.component.DaggerAccountLoginComponent;
import com.fxx.component.account.di.module.AccountLoginModule;
import com.fxx.component.account.mvp.contract.AccountLoginContract;
import com.fxx.component.account.mvp.model.entity.LoginToken;
import com.fxx.component.account.mvp.presenter.AccountLoginPresenter;
import com.fxx.component.commonres.dialog.ProgresDialog;
import com.fxx.component.commonsdk.core.RouterHub;
import com.fxx.component.commonsdk.utils.Constant;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DataHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;

@Route(path = RouterHub.ACCOUNT_LOGINACTIVITY)
public class AccountLoginActivity extends BaseActivity<AccountLoginPresenter> implements AccountLoginContract.View {

    @BindView(R2.id.txt_phone)
    TextInputEditText txtPhone;
    @BindView(R2.id.txt_password)
    TextInputEditText txtPassword;
    @BindView(R2.id.txt_login)
    TextView txtLogin;

    private String str_phone;
    private String str_password;


    private ProgresDialog progresDialog;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerAccountLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .accountLoginModule(new AccountLoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.account_activity_account_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        progresDialog = new ProgresDialog(this);


        txtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                str_phone = s.toString();
                if (!TextUtils.isEmpty(str_phone)&&!TextUtils.isEmpty(str_password)){
                    if (!txtLogin.isClickable()){
                        txtLogin.setClickable(true);
                        txtLogin.setBackgroundResource(R.drawable.account_shape_btn_cicle_click);
                    }

                }else {
                    if (txtLogin.isClickable()){
                        txtLogin.setClickable(false);
                        txtLogin.setBackgroundResource(R.drawable.account_shape_btn_cicle);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                str_password = s.toString();
                if (!TextUtils.isEmpty(str_phone)&&!TextUtils.isEmpty(str_password)){
                    if (!txtLogin.isClickable()){
                        txtLogin.setClickable(true);
                        txtLogin.setBackgroundResource(R.drawable.account_shape_btn_cicle_click);
                    }

                }else {
                    if (txtLogin.isClickable()){
                        txtLogin.setClickable(false);
                        txtLogin.setBackgroundResource(R.drawable.account_shape_btn_cicle);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void showLoading() {
        progresDialog.show();
    }

    @Override
    public void hideLoading() {
        progresDialog.dismiss();
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



    @OnClick(R2.id.txt_login)
    public void onViewClicked() {
        mPresenter.requestLogin(txtPhone.getText().toString(),txtPassword.getText().toString());
    }

    @Override
    public void onShowLoginResult(LoginToken data) {
        DataHelper.setStringSF(this, Constant.COMMON_TOKEN,data.getAccess_token());
        ARouter.getInstance().build(RouterHub.ACCOUNT_ACCOUNTROLECONSOLEACTIVITY)
                .withString(Conts.ACCOUNT_TOKEN,data.getAccess_token())
                .navigation();
        finish();
    }
}
