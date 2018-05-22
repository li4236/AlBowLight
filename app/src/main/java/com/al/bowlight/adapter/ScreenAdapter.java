package com.al.bowlight.adapter;

import android.content.Context;

import com.al.bowlight.R;
import com.al.bowlight.base.AlRBaseAdapter;
import com.al.bowlight.base.AlRViewHolder;
import com.al.bowlight.bean.ScreenInfo;

import java.util.List;

/**
 * Created by li4236 on 2018/5/22.
 */

public class ScreenAdapter extends AlRBaseAdapter<ScreenInfo> {
    public ScreenAdapter(Context context, List<ScreenInfo> list) {
        super(context, list);
    }

    @Override
    protected void bindDataToItemView(AlRViewHolder viewHolder, ScreenInfo item, int position) {

        viewHolder.setTextView(R.id.sc_name, item.getName());


        viewHolder.setImageResource(R.id.sc_ico, item.getPath());

    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_screen_top;
    }
}
