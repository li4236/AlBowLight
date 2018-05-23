package com.al.bowlight.fragment;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.al.bowlight.R;
import com.al.bowlight.adapter.ScreenAdapter;
import com.al.bowlight.adapter.ScreenBotAdapter;
import com.al.bowlight.base.BaseFragment;
import com.al.bowlight.bean.ScreenInfo;
import com.al.bowlight.impl.onAlItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li4236 on 2018/5/22.
 */

public class ScreenFragment extends BaseFragment {

    private RecyclerView mTopRv, mBottomRv;


    private ImageView mTopIv, mBottomTv;
    private EditText mTopEdit, mBottomEdit;

    private boolean mSelect;

    @Override
    protected int onLayoutId() {
        return R.layout.pop_time;
    }

    @Override
    protected void onInitView() {

        initView();

        initData();
    }

    public void initView() {

        mTopIv = mViewGroup.findViewById(R.id.pop_top_close);

        mTopEdit = mViewGroup.findViewById(R.id.pop_top_edit);

        mBottomTv = mViewGroup.findViewById(R.id.pop_bottom_close);

        mBottomEdit = mViewGroup.findViewById(R.id.pop_bottom_edit);


        mTopIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag() == null) {
                    view.setTag("==");
                    mTopIv.setImageResource(R.mipmap.switch_open);
                } else {
                    view.setTag(null);
                    mTopIv.setImageResource(R.mipmap.switch_close);
                }
            }
        });

        mBottomTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag() == null) {
                    view.setTag("==");
                    mBottomTv.setImageResource(R.mipmap.switch_open);
                } else {
                    view.setTag(null);
                    mBottomTv.setImageResource(R.mipmap.switch_close);
                }
            }
        });


        final TimePicker timePicker = mViewGroup.findViewById(R.id.timePic1);

        timePicker.setIs24HourView(true);


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                if (mSelect){
                    mBottomEdit.setText(i+":"+i1);
                }else {
                    mTopEdit.setText(i+":"+i1);
                }

            }
        });


        mTopEdit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                mSelect = false;
                mTopEdit.setBackgroundResource(R.mipmap.display_box_blue);
                mTopEdit.setTextColor(getActivity().getResources().getColor(R.color.them));
                mBottomEdit.setTextColor(getActivity().getResources().getColor(R.color.themColor));
                mBottomEdit.setBackgroundResource(R.mipmap.display_box_gray);

                String timer = mTopEdit.getText().toString();
                String timers[] = timer.split(":");
                timePicker.setHour( Integer.parseInt(timers[0]));
                timePicker.setMinute(Integer.parseInt(timers[1]));
            }
        });

        mBottomEdit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                mSelect = true;
                mBottomEdit.setBackgroundResource(R.mipmap.display_box_blue);
                mTopEdit.setBackgroundResource(R.mipmap.display_box_gray);
                mBottomEdit.setTextColor(getActivity().getResources().getColor(R.color.them));
                mTopEdit.setTextColor(getActivity().getResources().getColor(R.color.themColor));

                String timer = mBottomEdit.getText().toString();
                String timers[] = timer.split(":");


                timePicker.setHour( Integer.parseInt(timers[0]));
                timePicker.setMinute(Integer.parseInt(timers[1]));
            }
        });
    }


//    public void initView() {
//
//        mTopRv = mViewGroup.findViewById(R.id.screen_top);
//
//        mBottomRv = mViewGroup.findViewById(R.id.screen_bottom);
//
//        //设置布局管理器
//        GridLayoutManager layoutManage = new GridLayoutManager(getContext(), 3);
//        GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
//        mTopRv.setLayoutManager(layoutManage);
//        mBottomRv.setLayoutManager(manager);
//
//        ScreenAdapter mAdapter = new ScreenAdapter(getContext(), getTopData());
//
//        mTopRv.setAdapter(mAdapter);
//
//        ScreenBotAdapter m = new ScreenBotAdapter(getContext(), getColorData());
//
//        mBottomRv.setAdapter(m);
//
//        mAdapter.setOnItemClickListener(new onAlItemClickListener<ScreenInfo>() {
//            @Override
//            public void onClick(View view, ScreenInfo item) {
//
//            }
//        });
//
//        m.setOnItemClickListener(new onAlItemClickListener() {
//            @Override
//            public void onClick(View view, Object item) {
//
//            }
//        });
//    }

    private void initData() {


    }


    public List<ScreenInfo> getTopData() {

        List<ScreenInfo> infos = new ArrayList<>();

        ScreenInfo info = new ScreenInfo();

        info.setName("顺序渐变");
        info.setPath(R.mipmap.smooth);
        infos.add(info);

        ScreenInfo info1 = new ScreenInfo();
        info1.setName("随机渐变");
        info1.setPath(R.mipmap.random_smooth);
        infos.add(info1);

        ScreenInfo info2 = new ScreenInfo();
        info2.setName("呼吸渐变");
        info2.setPath(R.mipmap.breathing);
        infos.add(info2);

        ScreenInfo info3 = new ScreenInfo();
        info3.setName("顺序跳变");
        info3.setPath(R.mipmap.change);
        infos.add(info3);

        ScreenInfo info4 = new ScreenInfo();
        info4.setName("随机跳变");
        info4.setPath(R.mipmap.random_change);
        infos.add(info4);

        ScreenInfo info5 = new ScreenInfo();
        info5.setName("爆闪跳变");
        info5.setPath(R.mipmap.flashing);
        infos.add(info5);


        return infos;

    }

    public List<ScreenInfo> getColorData() {

        List<ScreenInfo> infos = new ArrayList<>();

        ScreenInfo info = new ScreenInfo();


        info.setPath(Color.argb(255, 34, 64, 2));  // 半透明的紫色 );
        infos.add(info);


        ScreenInfo info3 = new ScreenInfo();

        info3.setPath(Color.argb(255, 0, 3, 178));  // 半透明的紫色 );
        infos.add(info3);

        ScreenInfo info1 = new ScreenInfo();

        info1.setPath(Color.argb(255, 254, 0, 0));  // 半透明的紫色 );
        infos.add(info1);

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
