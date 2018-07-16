package com.example.ling.testfragmention;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/3/28 0009
 * ***************************************
 */
public abstract class BaseDelegate extends SupportFragment implements View.OnClickListener {
    public final String TAG = this.getClass().getSimpleName();
    private View mRootView;

    public abstract Object setLayout();

    protected void initData() {

    }

    public abstract void initView(@Nullable Bundle savedInstanceState, @NonNull View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = null;
        if (setLayout() instanceof Integer) {
            mRootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            mRootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }

        if (mRootView != null) {
            initData();
            initView(savedInstanceState, mRootView);
        }
        return mRootView;
    }


    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        // 隐藏键盘
        hideSoftInput();
    }

    public void setBackguand(int color) {
        if (mRootView != null) {
            mRootView.setBackgroundColor(color);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

    }

}
