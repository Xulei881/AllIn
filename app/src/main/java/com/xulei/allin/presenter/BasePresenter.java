package com.xulei.allin.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by xulei on 2016/5/12.
 * MVP中的P，防止P持有强引用activity导致内存泄漏
 */
public abstract class BasePresenter<T> {
    //构建弱引用
    protected Reference<T> mViewRef;

    //将当前view存放在弱引用中
    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    //传入
    protected T getView() {
        if (isViewAttached())
            return mViewRef.get();
        return null;
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
