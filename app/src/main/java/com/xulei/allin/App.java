package com.xulei.allin;

import android.app.Application;
import android.content.Context;

/**
 * Created by xulei on 2016/5/12.
 * app
 */
public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }

}
