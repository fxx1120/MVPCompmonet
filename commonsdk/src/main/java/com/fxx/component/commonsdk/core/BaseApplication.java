package com.fxx.component.commonsdk.core;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;

import com.fxx.component.commonsdk.R;
import com.fxx.component.commonsdk.utils.DynamicTimeFormat;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;


/**
 * Created by fxx028 on 2018/11/27.
 */

public class BaseApplication extends com.jess.arms.base.BaseApplication {

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(android.R.color.black, android.R.color.black);//全局设置主题颜色
                ClassicsHeader mClassicsHeader = new ClassicsHeader(context);
                Drawable mDrawableProgress;
                int delta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
                mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis() - delta));
                mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));
                mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));
                mDrawableProgress = ((ImageView) mClassicsHeader.findViewById(ClassicsHeader.ID_IMAGE_PROGRESS)).getDrawable();
                if (mDrawableProgress instanceof LayerDrawable) {
                    mDrawableProgress = ((LayerDrawable) mDrawableProgress).getDrawable(0);
                }
                return mClassicsHeader;//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }


    @Override
    public void onCreate() {
        super.onCreate();

    }

}
