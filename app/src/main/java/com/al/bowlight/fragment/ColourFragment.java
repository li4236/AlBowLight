package com.al.bowlight.fragment;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.al.bowlight.R;
import com.al.bowlight.adapter.ScreenAdapter;
import com.al.bowlight.adapter.ScreenBotAdapter;
import com.al.bowlight.base.BaseFragment;
import com.al.bowlight.bean.ScreenInfo;
import com.al.bowlight.impl.onAlItemClickListener;
import com.al.bowlight.view.ColorPicker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li4236 on 2018/5/22.
 */

public class ColourFragment extends BaseFragment {

    private RecyclerView mBottomRv;
    @Override
    protected void onInitView() {
        initView();

    }

    @Override
    protected int onLayoutId() {
        return R.layout.fragment_colour;
    }

    public void initView() {


        mBottomRv = mViewGroup.findViewById(R.id.colour_bottom);

        //设置布局管理器
        GridLayoutManager manager = new GridLayoutManager(getContext(), 5);
        mBottomRv.setLayoutManager(manager);


        ScreenBotAdapter m = new ScreenBotAdapter(getContext(), getColorData());

        mBottomRv.setAdapter(m);


        m.setOnItemClickListener(new onAlItemClickListener() {
            @Override
            public void onClick(View view, Object item) {

            }
        });


        ColorPicker picker = mViewGroup.findViewById(R.id.picker);

        picker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {

            }
        });

        picker.setOnColorSelectedListener(new ColorPicker.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int color) {

            }
        });

        picker.getColor();


        final ImageView mClose = mViewGroup.findViewById(R.id.colour_close);

        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag() == null){
                    mClose.setImageResource(R.mipmap.lamp_switch_backage);
                    view.setTag("--");
                }else {
                    view.setTag(null);
                    mClose.setImageResource(R.mipmap.lamp_switch_press);
                }
            }
        });






        ImageView timer = mViewGroup.findViewById(R.id.colour_timer);

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initData() {


    }




    public List<ScreenInfo> getColorData() {

        List<ScreenInfo> infos = new ArrayList<>();


        ScreenInfo info2 = new ScreenInfo();

        info2.setPath(Color.argb(255, 255, 158, 2));  // 半透明的紫色 );
        infos.add(info2);


        ScreenInfo info4 = new ScreenInfo();

        info4.setPath(Color.argb(255, 255, 255, 0));  // 半透明的紫色 );
        infos.add(info4);

        ScreenInfo info5 = new ScreenInfo();

        info5.setPath(Color.argb(255, 1, 255, 2));  // 半透明的紫色 );
        infos.add(info5);

        ScreenInfo info6 = new ScreenInfo();

        info6.setPath(Color.argb(255, 0, 254, 255));  // 半透明的紫色 );
        infos.add(info6);

        ScreenInfo info7 = new ScreenInfo();

        info7.setPath(Color.argb(255, 0, 0, 254));  // 半透明的紫色 );
        infos.add(info7);


        return infos;

    }
}
