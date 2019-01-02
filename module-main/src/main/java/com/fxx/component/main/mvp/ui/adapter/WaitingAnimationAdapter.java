package com.fxx.component.main.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fxx.component.main.R;

import java.util.List;

public class WaitingAnimationAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public WaitingAnimationAdapter(List<String> beanList) {
        super(R.layout.main_item_homeb_waiting,beanList);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
