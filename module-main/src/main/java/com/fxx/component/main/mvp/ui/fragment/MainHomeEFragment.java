package com.fxx.component.main.mvp.ui.fragment;

import android.app.UiModeManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fxx.component.commonres.alert.SweetAlertDialog;
import com.fxx.component.commonres.glide.GlideCircleTransform;
import com.fxx.component.commonsdk.core.RouterHub;
import com.fxx.component.commonsdk.utils.Constant;
import com.fxx.component.commonsdk.utils.FileUtils;
import com.fxx.component.commonsdk.utils.Utils;
import com.fxx.component.main.R;
import com.fxx.component.main.R2;
import com.fxx.component.main.di.component.DaggerMainHomeEComponent;
import com.fxx.component.main.di.module.MainHomeEModule;
import com.fxx.component.main.mvp.contract.MainHomeEContract;
import com.fxx.component.main.mvp.presenter.MainHomeEPresenter;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DataHelper;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainHomeEFragment extends BaseFragment<MainHomeEPresenter> implements MainHomeEContract.View {

    @BindView(R2.id.public_toolbar_back)
    AutoRelativeLayout publicToolbarBack;
    @BindView(R2.id.public_toolbar_title)
    TextView publicToolbarTitle;
    @BindView(R2.id.user_avatar)
    ImageView userAvatar;
    @BindView(R2.id.user_name)
    TextView userName;
    @BindView(R2.id.user_mobile)
    TextView userMobile;
    @BindView(R2.id.user_information)
    LinearLayout userInformation;
    @BindView(R2.id.user_changerole)
    LinearLayout userChangerole;
    @BindView(R2.id.user_changpassword)
    LinearLayout userChangpassword;
    @BindView(R2.id.cache_file)
    TextView cacheFile;
    @BindView(R2.id.user_clear)
    LinearLayout userClear;
    @BindView(R2.id.app_version)
    TextView appVersion;
    @BindView(R2.id.user_version)
    LinearLayout userVersion;
    @BindView(R2.id.user_exit)
    LinearLayout userExit;
    Unbinder unbinder;

    public static MainHomeEFragment newInstance() {
        MainHomeEFragment fragment = new MainHomeEFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMainHomeEComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainHomeEModule(new MainHomeEModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_main_home_e, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        publicToolbarBack.setVisibility(View.INVISIBLE);
        publicToolbarTitle.setText("我的");
//        Glide.with(this).load(DataHelper.getStringSF(getContext(), Constant.COMMON_USER_AVATAR)).apply(new RequestOptions().error(R.drawable.public_default_avater)
//                .transform(new GlideCircleTransform(getActivity()))).into(userAvatar);
//        userMobile.setText(DataHelper.getStringSF(getActivity(), Constant.COMMON_USER_PHONE)
//                .subSequence(0, 3) + "****" + DataHelper.getStringSF(getActivity(), Constant.COMMON_USER_PHONE)
//                .subSequence(7, 11));
//        userName.setText(DataHelper.getStringSF(getContext(), Constant.COMMON_USER_NAME));
    }

    /**
     * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
     * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
     * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
     * <p>
     * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时 {@link Fragment#onCreate(Bundle)} 还没执行
     * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在 {@link Fragment#onCreate(Bundle)} 方法中执行的
     * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在 {@link #initData(Bundle)} 中初始化就可以了
     * <p>
     * Example usage:
     * <pre>
     * public void setData(@Nullable Object data) {
     *     if (data != null && data instanceof Message) {
     *         switch (((Message) data).what) {
     *             case 0:
     *                 loadData(((Message) data).arg1);
     *                 break;
     *             case 1:
     *                 refreshUI();
     *                 break;
     *             default:
     *                 //do something
     *                 break;
     *         }
     *     }
     * }
     *
     * // call setData(Object):
     * Message data = new Message();
     * data.what = 0;
     * data.arg1 = 1;
     * fragment.setData(data);
     * </pre>
     *
     * @param data 当不需要参数时 {@code data} 可以为 {@code null}
     */
    @Override
    public void setData(@Nullable Object data) {

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R2.id.user_changerole, R2.id.user_changpassword, R2.id.user_clear, R2.id.user_exit})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.user_changerole) {
            Utils.navigation(getActivity(), RouterHub.ACCOUNT_ACCOUNTROLECONSOLEACTIVITY);
        } else if (i == R.id.user_changpassword) {
            Utils.navigation(getActivity(), RouterHub.ACCOUNT_CHANGEPASSWORDACTIVITY);

        } else if (i == R.id.user_clear) {
            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("您确定要清除缓存?")
                    .setConfirmText("确认")
                    .setCancelText("取消")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            FileUtils.deleteFolderFile(getActivity().getExternalFilesDir(null).getAbsolutePath(), false);
                            cacheFile.setText("0B");
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                        }
                    }).show();
        } else if (i == R.id.user_exit) {
            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("您确定要退出?")
                    .setContentText("退出将清除当前账号所有信息")
                    .setConfirmText("确认")
                    .setCancelText("取消")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                            DataHelper.clearShareprefrence(getActivity());
                            Utils.navigation(getActivity(), RouterHub.ACCOUNT_LOGINACTIVITY);
                            mPresenter.clearAllAcitivity();
                        }
                    })
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                        }
                    }).show();
        }
    }
}
