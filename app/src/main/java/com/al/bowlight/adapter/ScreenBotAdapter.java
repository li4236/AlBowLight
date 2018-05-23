package com.al.bowlight.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;

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
    protected void bindDataToItemView(final AlRViewHolder viewHolder, final ScreenInfo item, int position) {


        ((CardView) viewHolder.get(R.id.sc_card)).setCardBackgroundColor(item.getPath());
//        (viewHolder.get(R.id.sc_card)).setBackgroundColor(item.getPath());
        viewHolder.get(R.id.sc_card).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((CardView) viewHolder.get(R.id.sc_card)).setCardBackgroundColor(Color.argb(255, 220, 220, 220));
                        break;
                    case MotionEvent.ACTION_MOVE:
                        ((CardView) viewHolder.get(R.id.sc_card)).setCardBackgroundColor(Color.argb(255, 220, 220, 220));
                        break;
                    case MotionEvent.ACTION_UP:
                        ((CardView) viewHolder.get(R.id.sc_card)).setCardBackgroundColor(item.getPath());
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        ((CardView) viewHolder.get(R.id.sc_card)).setCardBackgroundColor(item.getPath());
                        break;
                }
                return true;
            }
        });



    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_screen_bottom;
    }
}
