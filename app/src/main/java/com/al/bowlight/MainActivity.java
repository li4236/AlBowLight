package com.al.bowlight;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.al.bowlight.fragment.ColourFragment;
import com.al.bowlight.fragment.ScreenFragment;
import com.al.bowlight.util.ComToast;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private int mTabsId[] = {R.id.wholecity_buy_conduct,  R.id.wholecity_buy_crazy};

    private LinearLayout[] mTabs = new LinearLayout[mTabsId.length];

    //亿众淘、金币商城、抢疯了
    private Fragment[] mFragments = new Fragment[]{new ColourFragment(), new ScreenFragment()};

    public int index = 0;
    // 当前fragment的index
    private int currentTabIndex = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_new_main);
        initView();


        initData();

        // 添加显示第一个fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.wholecity_buy_framement, mFragments[index])

                .show(mFragments[index]).commit();


    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);  不让Fragment恢复，一起销毁
    }

    /**
     * 初始化视图
     */
    private void initView() {



        for (int i = 0; i < mTabsId.length; i++) {
            mTabs[i] =  findViewById(mTabsId[i]);
            mTabs[i].setOnClickListener(this);
        }


        // 把第一个tab设为选中状态
        mTabs[index].setSelected(true);




    }


    /**
     * 监听事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.wholecity_buy_conduct://亿众淘
                index = 0;
                break;

            case R.id.wholecity_buy_crazy://个人中心
                index = 1;

                break;
        }
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager()
                    .beginTransaction();
            trx.hide(mFragments[currentTabIndex]);
            if (!mFragments[index].isAdded()) {
                trx.add(R.id.wholecity_buy_framement, mFragments[index]);
            }
            trx.show(mFragments[index]).commit();
        }
        // 设置之前的为取消状态
        mTabs[currentTabIndex].setSelected(false);
        //设置之前的片段为不可视
//        mFragments[currentTabIndex].setUserVisibleHint(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        //设置当前的片段为可视
//        mFragments[index].setUserVisibleHint(true);
        currentTabIndex = index;

    }

    private void initData() {

    }




    @Override
    public void onResume() {
        super.onResume();

////        仅处理推送版本更新
//        if (!TextUtils.isEmpty(AlIndexUtil.getInstance().getUpdate())) {
//
//
//            VersionUpdate.checkVersion(NewMainActivity.this, NewMainActivity.class);
//        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                ComToast.S(this, "再按一次退出");
                touchTime = currentTime;
            } else {
               finish();
                finish();

            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private long waitTime = 2000;
    private long touchTime = 0;



}
