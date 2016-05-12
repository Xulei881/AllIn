package com.xulei.allin.model;

/**
 * Created by xulei on 2016/5/12.
 */
public class MenuModel {
    private String name;
    private int resId;

    public MenuModel(int resId, String name) {
        this.name = name;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
