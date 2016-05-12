package com.xulei.allin.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by xulei on 2016/5/12.
 */
public class ErrorActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView tv = new ImageView(this);
        setContentView(tv);

        Glide.with(ErrorActivity.this).
                load("http://img.juhe.cn/joke/201412/19/B0C3ABBEBBE0A6EA5B8FE04E27215FBC.gif").asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(tv);
    }
}
