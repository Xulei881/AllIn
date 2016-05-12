package com.xulei.allin.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.xulei.allin.presenter.BasePresenter;

/**
 * Created by xulei on 2016/5/12.
 * 通过Activity的生命周期管理其与Presenter的关系
 */
public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends BaseActivity {
    protected T mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
