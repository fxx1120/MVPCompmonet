package com.fxx.component.main.mvp.model.entity;

import java.io.Serializable;

/**
 * Created by fxx028 on 2018/12/3.
 */

public class openWindowBean implements Serializable{


    /**
     * title : 个人业绩排行
     * name : PeoplePerformance
     * params : {"user_type":1}
     * rotate : false
     */

    private String title;
    private String name;
    private ParamsBean params;
    private boolean rotate = false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public boolean isRotate() {
        return rotate;
    }

    public void setRotate(boolean rotate) {
        this.rotate = rotate;
    }

    public static class ParamsBean {
        /**
         * user_type : 1
         */

        private int user_type;

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }
    }
}
