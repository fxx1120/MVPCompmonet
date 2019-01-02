package com.fxx.component.main.mvp.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.fxx.component.commonres.alert.SweetAlertDialog;
import com.fxx.component.commonsdk.core.RouterHub;
import com.fxx.component.commonsdk.manager.PermissionManager;
import com.fxx.component.commonsdk.utils.AppConstant;
import com.fxx.component.main.R;
import com.fxx.component.main.di.component.DaggerMainHomeComponent;
import com.fxx.component.main.di.module.MainHomeModule;
import com.fxx.component.main.impl.BackHandledInterface;
import com.fxx.component.main.mvp.contract.MainHomeContract;
import com.fxx.component.main.mvp.model.entity.MainTabEntity;
import com.fxx.component.main.mvp.presenter.MainHomePresenter;
import com.fxx.component.main.mvp.ui.fragment.MainHomeAFragment;
import com.fxx.component.main.mvp.ui.fragment.MainHomeBFragment;
import com.fxx.component.main.mvp.ui.fragment.MainHomeCFragment;
import com.fxx.component.main.mvp.ui.fragment.MainHomeDFragment;
import com.fxx.component.main.mvp.ui.fragment.MainHomeEFragment;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DeviceUtils;
import com.pgyersdk.crash.PgyCrashManager;
import com.pgyersdk.feedback.PgyerFeedbackManager;
import com.pgyersdk.update.DownloadFileListener;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;
import com.pgyersdk.update.javabean.AppBean;



import java.util.ArrayList;

import static com.jess.arms.utils.Preconditions.checkNotNull;

@Route(path = RouterHub.MAIN_MAINHOMEACTIVITY)
public class MainHomeActivity extends BaseActivity<MainHomePresenter> implements MainHomeContract.View {


    private CommonTabLayout commonTablayout;
    private String[] mTitles = {"看板", "消息", "工作台", "发现", "我的"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private int[] mIconUnselectIds = {
            R.drawable.main_a, R.drawable.main_b, R.drawable.main_c, R.drawable.main_d, R.drawable.main_e};
    private int[] mIconSelectIds = {
            R.drawable.main_a_ed, R.drawable.main_b_ed, R.drawable.main_c_ed, R.drawable.main_d_ed, R.drawable.main_e_ed};

    private MainHomeAFragment AFragment;
    private MainHomeBFragment BFragment;
    private MainHomeCFragment CFragment;
    private MainHomeDFragment DFragment;
    private MainHomeEFragment EFragment;

    protected BackHandledInterface mBackHandledInterface;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainHomeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainHomeModule(new MainHomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.main_activity_main_home; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        commonTablayout = findViewById(R.id.common_tablayout);
        initTab();
        commonTablayout.measure(0, 0);
        initFragment(savedInstanceState);
        PermissionManager.initPermission(this);

        // 默认采用摇一摇弹出 Dialog 方式
        new PgyerFeedbackManager.PgyerFeedbackBuilder().builder().register();

        //检查更新
//        new PgyUpdateManager.Builder()
//                .setForced(true)                //设置是否强制更新,非自定义回调更新接口此方法有用
//                .setUserCanRetry(false)         //失败后是否提示重新下载，非自定义下载 apk 回调此方法有用
//                .setDeleteHistroyApk(false)     // 检查更新前是否删除本地历史 Apk， 默认为true
//                .setUpdateManagerListener(new UpdateManagerListener() {
//                    @Override
//                    public void onNoUpdateAvailable() {
//                        //没有更新是回调此方法
//                        Log.d("pgyer", "there is no new version");
//                    }
//
//                    @Override
//                    public void onUpdateAvailable(AppBean appBean) {
//                        //有更新回调此方法
//                        Log.d("pgyer", "there is new version can update"
//                                + "new versionCode is " + appBean.getVersionCode());
//                        //调用以下方法，DownloadFileListener 才有效；
//                        //如果完全使用自己的下载方法，不需要设置DownloadFileListener
//                        PgyUpdateManager.downLoadApk(appBean.getDownloadURL());
//                    }
//
//                    @Override
//                    public void checkUpdateFailed(Exception e) {
//                        //更新检测失败回调
//                        //更新拒绝（应用被下架，过期，不在安装有效期，下载次数用尽）以及无网络情况会调用此接口
//                        Log.e("pgyer", "check update failed ", e);
//                    }
//                })
//                //注意 ：
//                //下载方法调用 PgyUpdateManager.downLoadApk(appBean.getDownloadURL()); 此回调才有效
//                //此方法是方便用户自己实现下载进度和状态的 UI 提供的回调
//                //想要使用蒲公英的默认下载进度的UI则不设置此方法
//                .setDownloadFileListener(new DownloadFileListener() {
//                    @Override
//                    public void downloadFailed() {
//                        //下载失败
//                        Log.e("pgyer", "download apk failed");
//                    }
//
//                    @Override
//                    public void downloadSuccessful(Uri uri) {
//                        Log.e("pgyer", "download apk failed");
//                        // 使用蒲公英提供的安装方法提示用户 安装apk
//                        PgyUpdateManager.installApk(uri);
//                    }
//
//                    @Override
//                    public void onProgressUpdate(Integer... integers) {
//                        Log.e("pgyer", "update download apk progress" + integers);
//                    }
//                })
//                .register();


//        new SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE)
//                .setTitleText("使用提示?")
//                .setContentText("你在任何页面摇一摇手机均可截屏反馈使用问题")
//                .setConfirmText("好的，知道了")
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        sDialog.dismissWithAnimation();
//                    }
//                }).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    /**
     * 初始化碎片
     */
    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            AFragment = (MainHomeAFragment) getSupportFragmentManager().findFragmentByTag("AFragment");
            BFragment = (MainHomeBFragment) getSupportFragmentManager().findFragmentByTag("BFragment");
            CFragment = (MainHomeCFragment) getSupportFragmentManager().findFragmentByTag("CFragment");
            DFragment = (MainHomeDFragment) getSupportFragmentManager().findFragmentByTag("DFragment");
            EFragment = (MainHomeEFragment) getSupportFragmentManager().findFragmentByTag("EFragment");
            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            AFragment = MainHomeAFragment.newInstance();
            BFragment = MainHomeBFragment.newInstance();
            CFragment = MainHomeCFragment.newInstance();
            DFragment = MainHomeDFragment.newInstance();
            EFragment = MainHomeEFragment.newInstance();

            transaction.add(R.id.common_framelayout, AFragment, "AFragment");
            transaction.add(R.id.common_framelayout, BFragment, "BFragment");
            transaction.add(R.id.common_framelayout, CFragment, "CFragment");
            transaction.add(R.id.common_framelayout, DFragment, "DFragment");
            transaction.add(R.id.common_framelayout, EFragment, "EFragment");
        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        commonTablayout.setCurrentTab(currentTabPosition);
    }

    /**
     * 初始化tab
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new MainTabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTablayout.setTabData(mTabEntities);
        //点击监听
        commonTablayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }


    /**
     * 切换
     */
    private void SwitchTo(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                transaction.hide(EFragment);
                transaction.hide(DFragment);
                transaction.hide(CFragment);
                transaction.hide(BFragment);
                transaction.show(AFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 1:
                transaction.hide(EFragment);
                transaction.hide(DFragment);
                transaction.hide(CFragment);
                transaction.show(BFragment);
                transaction.hide(AFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 2:
                transaction.hide(EFragment);
                transaction.hide(DFragment);
                transaction.show(CFragment);
                transaction.hide(BFragment);
                transaction.hide(AFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 3:
                transaction.hide(EFragment);
                transaction.show(DFragment);
                transaction.hide(CFragment);
                transaction.hide(BFragment);
                transaction.hide(AFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 4:
                transaction.show(EFragment);
                transaction.hide(DFragment);
                transaction.hide(CFragment);
                transaction.hide(BFragment);
                transaction.hide(AFragment);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
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


    public void setBackHandledInterface(BackHandledInterface backHandledInterface) {
        this.mBackHandledInterface = backHandledInterface;
    }


    @Override
    public void onBackPressed() {
        mBackHandledInterface.setSelectedFragment(this);
    }



}


