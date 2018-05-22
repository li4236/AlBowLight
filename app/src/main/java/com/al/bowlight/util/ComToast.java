package com.al.bowlight.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 当为true的时候输出调试信息,为false的时候不会输出调试信息
 * Toast统一管理类
 */
public class ComToast {

    private static Toast mToast = null;


    public static boolean Control = true;

    public static void S(Context mContext, CharSequence msg) {
        if (TextUtils.isEmpty(msg)|| mContext==null) {
            return;
        }
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void L(Context mContext, CharSequence msg) {
        if (TextUtils.isEmpty(msg)|| mContext==null) {
            return;
        }
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(mContext, msg, Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void Debug(Context mContext, CharSequence msg) {

        if (TextUtils.isEmpty(msg)|| mContext==null) {
            return;
        }
        if (Control) {

            if (mToast != null) {
                mToast.cancel();
            }
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
            mToast.show();
        }
    }

}