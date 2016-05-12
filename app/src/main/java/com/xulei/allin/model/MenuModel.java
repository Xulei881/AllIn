package com.xulei.allin.model;

/**
 * Created by xulei on 2016/5/12.
 */
public class MenuModel {
    private int id;
    private String name;
    private int resId;

    public MenuModel(int id, int resId, String name) {
        this.id = id;
        this.name = name;
        this.resId = resId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
