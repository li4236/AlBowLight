package com.al.bowlight.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.Toast;

import com.al.bowlight.R;
import com.al.bowlight.util.ComToast;

/**
 * Created by lee on 2018/5/23.
 */

public class TimePopupWindow extends PopupWindow {


    private ImageView mTopIv, mBottomTv;
    private EditText mTopEdit, mBottomEdit;

    private View mViewGroup;

    private boolean mSelect;

    private Context mContext;

    public TimePopupWindow(final Activity context) {
        super(context);

        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewGroup = inflater.inflate(R.layout.pop_time, null);

        //设置SelectPicPopupWindow的View
        this.setContentView(mViewGroup);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LinearLayout.LayoutParams.FILL_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.anim_menu_bottombar);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);

        initView();


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

                if (mSelect) {
                    mBottomEdit.setText(i + ":" + i1);
                } else {
                    mTopEdit.setText(i + ":" + i1);
                }

            }
        });


        mTopEdit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                mSelect = false;
                mTopEdit.setBackgroundResource(R.mipmap.display_box_blue);
                mTopEdit.setTextColor(mContext.getResources().getColor(R.color.them));
                mBottomEdit.setTextColor(mContext.getResources().getColor(R.color.themColor));
                mBottomEdit.setBackgroundResource(R.mipmap.display_box_gray);

                String timer = mTopEdit.getText().toString();
                String timers[] = timer.split(":");
                timePicker.setHour(Integer.parseInt(timers[0]));
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
                mBottomEdit.setTextColor(mContext.getResources().getColor(R.color.them));
                mTopEdit.setTextColor(mContext.getResources().getColor(R.color.themColor));

                String timer = mBottomEdit.getText().toString();
                String timers[] = timer.split(":");


                timePicker.setHour(Integer.parseInt(timers[0]));
                timePicker.setMinute(Integer.parseInt(timers[1]));
            }
        });

        mViewGroup.findViewById(R.id.pop_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        mViewGroup.findViewById(R.id.pop_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComToast.S(mContext, "保存");
            }
        });
    }

}
