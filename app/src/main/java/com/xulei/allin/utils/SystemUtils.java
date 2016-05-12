package com.xulei.allin.utils;

import android.content.ClipboardManager;
import android.content.Context;

/**
 * Created by xulei on 2016/5/12.
 */
public class SystemUtils {

    /**
     * 将str添加到剪贴板管理器中
     *
     * @param context
     * @param text
     */
    public static void copyText(Context context, String text) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(text);
    }

    /**
     * 由剪贴板管理器得到内容
     *
     * @param context
     * @return
     */
    public static String getCopyText(Context context) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        String text = cmb.getText().toString().trim();
        return text;
    }

}
