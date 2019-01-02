package com.fxx.component.main.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fxx.component.main.R;

import java.util.List;

public class MessageAnimationAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MessageAnimationAdapter(List<String> beanList) {
        super(R.layout.main_item_homeb_message,beanList);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
