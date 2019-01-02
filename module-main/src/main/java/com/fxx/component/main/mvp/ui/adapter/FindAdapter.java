package com.fxx.component.main.mvp.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fxx.component.main.R;
import com.fxx.component.main.mvp.model.entity.FindNewsBean;

import java.util.List;

public class FindAdapter extends BaseQuickAdapter<FindNewsBean.DataBean.RowsBean, BaseViewHolder> {

    public FindAdapter(List<FindNewsBean.DataBean.RowsBean> data) {
        super(R.layout.main_item_find_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindNewsBean.DataBean.RowsBean item) {

        if (item.getType() == 2) {
            if (item.getIsFail() == 1) {
                Glide.with(mContext).load(R.drawable.main_bzzc_off).into((ImageView) helper.getView(R.id.iv_find_icon));
            } else {
                Glide.with(mContext).load(R.drawable.main_bzzc_on).into((ImageView) helper.getView(R.id.iv_find_icon));
            }
        } else if (item.getType() == 1) {
            if (item.getIsFail() == 1) {
                Glide.with(mContext).load(R.drawable.main_zcfg_off).into((ImageView) helper.getView(R.id.iv_find_icon));
            } else {
                Glide.with(mContext).load(R.drawable.main_zcfg_on).into((ImageView) helper.getView(R.id.iv_find_icon));
            }
        }

        helper.setText(R.id.tv_find_name, item.getNamecn())
                .setText(R.id.tv_find_documentNum, "文件编号: " + item.getDocumentNum())
                .setText(R.id.tv_find_province, "适用区域: " + item.getProvince())
                .setText(R.id.tv_find_pubDate, "发布日期: " + item.getPubDate())
                .setText(R.id.tv_find_implDate, "实施日期: " + item.getImplDate());
    }
}
