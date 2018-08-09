package com.al.bowlight.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.al.bowlight.R;
import com.al.bowlight.base.AlRBaseAdapter;
import com.al.bowlight.base.AlRViewHolder;
import com.al.bowlight.bean.ScreenInfo;

import java.util.List;

/**
 * Created by li4236 on 2018/5/22.
 */

public class ScreenAdapter extends AlRBaseAdapter<ScreenInfo> {

    private int mPosition = -1;

    public ScreenAdapter(Context context, List<ScreenInfo> list) {
        super(context, list);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void bindDataToItemView(AlRViewHolder viewHolder, ScreenInfo item, int position) {

        viewHolder.setTextView(R.id.sc_name, item.getName());


        if (position == mPosition) {
            viewHolder.get(R.id.sc_name).setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.scene));
        } else {
            viewHolder.get(R.id.sc_name).setBackgroundDrawable(null);
        }


        viewHolder.setImageResource(R.id.sc_ico, item.getPath());

    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_screen_top;
    }

    public void setChangeColor(int changeColor) {
        mPosition = changeColor;
        notifyDataSetChanged();
    }
}
