package com.al.bowlight.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;

import com.al.bowlight.R;
import com.al.bowlight.base.AlRBaseAdapter;
import com.al.bowlight.base.AlRViewHolder;
import com.al.bowlight.bean.ScreenInfo;

import java.util.List;

/**
 * Created by li4236 on 2018/5/22.
 */

public class ScreenBotAdapter extends AlRBaseAdapter<ScreenInfo> {
    public ScreenBotAdapter(Context context, List<ScreenInfo> list) {
        super(context, list);
    }

    @Override
    protected void bindDataToItemView(AlRViewHolder viewHolder, ScreenInfo item, int position) {


        ((CardView)viewHolder.get(R.id.sc_card)).setCardBackgroundColor(item.getPath());


    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_screen_bottom;
    }
}
