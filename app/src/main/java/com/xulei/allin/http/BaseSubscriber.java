package com.xulei.allin.http;


import com.xulei.allin.view.BaseView;

import java.net.SocketException;

import rx.Subscriber;

/**
 * Created by xulei on 2016/3/1.
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private BaseView view;

    private boolean isLayout = true;

    public BaseSubscriber(BaseView view) {
        this.view = view;
    }

    @Override
    public void onCompleted() {
//        view.hideLoading();
        unsubscribe();
    }

    @Override
    public void onError(Throwable e) {
//        view.hideLoading();
        if (e instanceof SocketException) {
//            view.showNetError(isLayout());
        } else {
//            view.showError(isLayout());
        }
        requestFailed(e);
        unsubscribe();
    }

    public boolean isLayout() {
        return isLayout;
    }

    @Override
    public void onNext(T t) {
        requestSuccess(t);
    }

    public abstract void requestSuccess(T t);

    public abstract void requestFailed(Throwable e);
}
