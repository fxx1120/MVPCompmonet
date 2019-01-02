package com.fxx.component.main.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fxx.component.commonsdk.constants.FindNewsTypeConstant;
import com.fxx.component.commonsdk.core.RouterHub;
import com.fxx.component.commonsdk.utils.Utils;
import com.fxx.component.main.R;
import com.fxx.component.main.R2;
import com.fxx.component.main.di.component.DaggerMainHomeDComponent;
import com.fxx.component.main.di.module.MainHomeDModule;
import com.fxx.component.main.mvp.contract.MainHomeDContract;
import com.fxx.component.main.mvp.model.entity.FindNewsBean;
import com.fxx.component.main.mvp.presenter.MainHomeDPresenter;
import com.fxx.component.main.mvp.ui.adapter.FindAdapter;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.widget.autolayout.AutoToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhihu.matisse.internal.utils.UIUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainHomeDFragment extends BaseFragment<MainHomeDPresenter> implements MainHomeDContract.View {

    @BindView(R2.id.public_toolbar_back)
    AutoRelativeLayout mPublicToolbarBack;
    @BindView(R2.id.public_toolbar_title)
    TextView mPublicToolbarTitle;
    @BindView(R2.id.toolbar_right)
    TextView mToolbarRight;
    @BindView(R2.id.public_toolbar)
    AutoToolbar mPublicToolbar;
    @BindView(R2.id.toolbar)
    AutoToolbar mToolbar;
    @BindView(R2.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private FindAdapter mFindAdapter;
    private List<FindNewsBean.DataBean.RowsBean> newsBeanList = new ArrayList<>();

    public static MainHomeDFragment newInstance() {
        MainHomeDFragment fragment = new MainHomeDFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMainHomeDComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainHomeDModule(new MainHomeDModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_main_home_d, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initTitle();
        mRefreshLayout.setEnableLoadMore(false);
        initAdapter();
        mRefreshLayout.autoRefresh();
        requestData();
    }

    private void requestData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("limit", 20);
        mPresenter.requestFindNews(map);
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFindAdapter = new FindAdapter(newsBeanList);
        mFindAdapter.openLoadAnimation();
        mFindAdapter.setNotDoAnimationCount(4);
        mFindAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ARouter.getInstance().build(RouterHub.FIND_NEWDETAILACTIVITY)
                        .withString("id", mFindAdapter.getItem(position).getId())
                        .navigation();
            }
        });
        mRecyclerView.setAdapter(mFindAdapter);
    }

    private void initTitle() {
        mPublicToolbarBack.setVisibility(View.INVISIBLE);
        mPublicToolbarTitle.setText("发现");
        mToolbarRight.setText("我的收藏");
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
    public void onShowResult(FindNewsBean data) {
        newsBeanList.clear();
        newsBeanList.addAll(data.getData().getRows());
        mFindAdapter.notifyDataSetChanged();
    }

    @OnClick({R2.id.ll_find_safe, R2.id.ll_find_environmental, R2.id.ll_find_career, R2.id.toolbar_right})
    public void onViewClicked(View view) {
        int id = view.getId();
        String type;
        if (id == R.id.ll_find_safe) {
            type = FindNewsTypeConstant.INFORMATION_MODE_SAFE;
            startRouter(type);
        } else if (id == R.id.ll_find_environmental) {
            type = FindNewsTypeConstant.INFORMATION_MODE_ENVIRONMENT;
            startRouter(type);
        } else if (id == R.id.ll_find_career) {
            type = FindNewsTypeConstant.INFORMATION_MODE_CAREER;
            startRouter(type);
        } else if (id == R.id.toolbar_right) {
            Utils.navigation(getActivity(),RouterHub.FIND_MYCOLLECTIONNEWSACTIVITY);
        }
    }

    public void startRouter(String type) {
        ARouter.getInstance().build(RouterHub.FIND_NEWMANAGEACTIVITY)
                .withString(FindNewsTypeConstant.FINDNEW_TYPE, type)
                .navigation();
    }
}
