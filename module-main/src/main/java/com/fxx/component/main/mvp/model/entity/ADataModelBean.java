package com.fxx.component.main.mvp.model.entity;

import java.io.Serializable;

/**
 * Created by fxx028 on 2018/12/3.
 */

public class ADataModelBean implements Serializable{
    private String name;
    private String key;

    public ADataModelBean(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
