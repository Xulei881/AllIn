package com.xulei.allin.presenter;

import com.xulei.allin.AppConstants;
import com.xulei.allin.api.IIdCardApi;
import com.xulei.allin.http.BaseSubscriber;
import com.xulei.allin.http.RetrofitUtil;
import com.xulei.allin.model.IdCardModel;
import com.xulei.allin.view.IIdCardView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xulei on 2016/5/12.
 */
public class IdCardPresenter extends BasePresenter<IIdCardView> {


    public void loadIdCardInfo(String num) {

        RetrofitUtil
                .getInstance()
                .createApi(IIdCardApi.class)
                .loadCardInfo(num, "json", AppConstants.ID_CARD_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<IdCardModel>(getView()) {
                    @Override
                    public void requestSuccess(IdCardModel resp) {
                        if (isViewAttached()) {
                            getView().renderIdCardInfo(resp);
                        }
                    }

                    @Override
                    public void requestFailed(Throwable e) {
                    }
                });
    }
}
