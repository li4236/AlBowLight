package com.al.bowlight.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by li4236 on 2018/5/22.
 */

public abstract class BaseFragment extends Fragment {


    public ViewGroup mViewGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mViewGroup == null) {

            mViewGroup = (ViewGroup) LayoutInflater.from(getActivity()).inflate(onLayoutId(), null);

            onInitView();

        } else {

            ViewGroup parent = (ViewGroup) mViewGroup.getParent();

            if (parent != null) {

                parent.removeAllViews();
            }
        }

        return mViewGroup;
    }



    protected abstract int onLayoutId();

    protected abstract void onInitView();
}
