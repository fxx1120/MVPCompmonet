package com.fxx.component.main.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.fxx.component.main.R;
import com.fxx.component.main.R2;
import com.fxx.component.main.di.component.DaggerMainHomeBComponent;
import com.fxx.component.main.di.module.MainHomeBModule;
import com.fxx.component.main.mvp.contract.MainHomeBContract;
import com.fxx.component.main.mvp.model.entity.MainTabEntity;
import com.fxx.component.main.mvp.presenter.MainHomeBPresenter;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.widget.autolayout.AutoToolbar;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainHomeBFragment extends BaseFragment<MainHomeBPresenter> implements MainHomeBContract.View {

    @BindView(R2.id.public_toolbar_back)
    AutoRelativeLayout publicToolbarBack;
    @BindView(R2.id.public_toolbar_title)
    TextView publicToolbarTitle;
    @BindView(R2.id.toolbar_right)
    TextView toolbarRight;
    @BindView(R2.id.public_toolbar)
    AutoToolbar publicToolbar;
    @BindView(R2.id.tl_b_type)
    CommonTabLayout tlBType;
    @BindView(R2.id.fl_b_type)
    FrameLayout flBType;
    Unbinder unbinder;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();
    private String[] mTitles = {"待办", "消息"};

    public static MainHomeBFragment newInstance() {
        MainHomeBFragment fragment = new MainHomeBFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMainHomeBComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainHomeBModule(new MainHomeBModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_main_home_b, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        publicToolbarBack.setVisibility(View.INVISIBLE);
        publicToolbarTitle.setText("消息");
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new MainTabEntity(mTitles[i],0,0));
        }

        mFragments2.add(HomeBFragmentWaitingFragment.newInstance());
        mFragments2.add(HomeBFragmentMessageFragment.newInstance());

        tlBType.setTabData(mTabEntities,getActivity(),R.id.fl_b_type,mFragments2);
        tlBType.setCurrentTab(0);



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
}
