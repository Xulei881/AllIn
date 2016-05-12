package com.xulei.allin.widget.cardview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xulei.allin.R;


/**
 */
@SuppressLint("NewApi")
public class CardItemView extends LinearLayout {

    public TextView contentTv;

    public CardItemView(Context context) {
        this(context, null);
    }

    public CardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflate(context, R.layout.card_item, this);
        contentTv = (TextView) findViewById(R.id.id_card_item_content_tv);

    }

    public void fillData(CardDataItem itemData) {
        contentTv.setText(itemData.content);
    }
}
