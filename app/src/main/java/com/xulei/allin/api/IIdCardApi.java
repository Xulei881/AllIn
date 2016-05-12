package com.xulei.allin.api;

import com.xulei.allin.model.IdCardModel;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by xulei on 2016/5/12.
 */
public interface IIdCardApi {

    @GET("http://apis.juhe.cn/idcard/index")
    Observable<IdCardModel> loadCardInfo(
            @Query("cardno") String cardno,
            @Query("dtype") String json,
            @Query("key") String key);
}
