package com.al.bowlight.impl;

import android.view.View;

/**
 * Created by 123 on 2016/5/3.
 */
public interface AlOnItemLongClickListener <T> {
    void onLongClick(View view, T item,int position);
}