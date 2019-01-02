package com.fxx.component.main.mvp.model.entity;

import java.io.Serializable;

/**
 * Created by fxx028 on 2018/12/4.
 */

public class WebUserInfoBean implements Serializable{
    private String access_token;
    private String extend_id;
    private String type;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExtend_id() {
        return extend_id;
    }

    public void setExtend_id(String extend_id) {
        this.extend_id = extend_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
