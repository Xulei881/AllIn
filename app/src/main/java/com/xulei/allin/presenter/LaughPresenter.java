package com.xulei.allin.presenter;

import com.xulei.allin.AppConstants;
import com.xulei.allin.api.ILaughApi;
import com.xulei.allin.http.BaseSubscriber;
import com.xulei.allin.http.RetrofitUtil;
import com.xulei.allin.model.LaughModel;
import com.xulei.allin.view.ILaughView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xulei on 2016/5/12.
 */
public class LaughPresenter extends BasePresenter<ILaughView> {

    public void loadNewLaugh() {
        RetrofitUtil
                .getInstance()
                .createApi(ILaughApi.class)
                .loadNewJoke(1, 18, AppConstants.LAUGH_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<LaughModel>(getView()) {
                    @Override
                    public void requestSuccess(LaughModel resp) {
                        if (isViewAttached())
                            getView().renderLaugh(resp);
                    }

                    @Override
                    public void requestFailed(Throwable e) {
                    }
                });
    }
}
