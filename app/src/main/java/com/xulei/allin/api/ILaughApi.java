package com.xulei.allin.api;

import com.xulei.allin.model.LaughModel;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by xulei on 2016/5/12.
 */
public interface ILaughApi {

    @GET("http://japi.juhe.cn/joke/content/text.from")
    Observable<LaughModel> loadNewJoke(
            @Query("page") int page,
            @Query("pagesize") int pagesize,
            @Query("key") String key);

}
