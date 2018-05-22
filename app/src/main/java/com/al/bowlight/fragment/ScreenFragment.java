package com.al.bowlight.fragment;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

    @Override
    protected int onLayoutId() {
        return R.layout.fragment_screen;
    }

    @Override
    protected void onInitView() {

        initView();

        initData();
    }


    public void initView() {

        mTopRv = mViewGroup.findViewById(R.id.screen_top);

        mBottomRv = mViewGroup.findViewById(R.id.screen_bottom);

        //设置布局管理器
        GridLayoutManager layoutManage = new GridLayoutManager(getContext(), 3);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        mTopRv.setLayoutManager(layoutManage);
        mBottomRv.setLayoutManager(manager);

        ScreenAdapter mAdapter = new ScreenAdapter(getContext(), getTopData());

        mTopRv.setAdapter(mAdapter);

        ScreenBotAdapter m = new ScreenBotAdapter(getContext(), getColorData());

        mBottomRv.setAdapter(m);

        mAdapter.setOnItemClickListener(new onAlItemClickListener<ScreenInfo>() {
            @Override
            public void onClick(View view, ScreenInfo item) {

            }
        });

        m.setOnItemClickListener(new onAlItemClickListener() {
            @Override
            public void onClick(View view, Object item) {

            }
        });
    }

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
