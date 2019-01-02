package com.fxx.component.main.mvp.model.entity;

import android.support.annotation.DrawableRes;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by fxx028 on 2018/11/15.
 */

public class MainTabEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public MainTabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
