package com.example.ling.testfragmention;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import me.yokeyword.fragmentation.ISupportFragment;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/7/16 0016
 * ***************************************
 */
public class OneDelegate extends BaseDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_one;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        rootView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(new TwoDelegate());
            }
        });
    }
}
