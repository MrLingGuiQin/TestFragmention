package com.example.ling.testfragmention;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018-03-28
 * ***************************************
 */
public abstract class ProxyActivity extends SupportActivity {
    public final String TAG = this.getClass().getSimpleName();
    public View mStatusBarView;

    public abstract BaseDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.delegate_container);
        mStatusBarView = findViewById(R.id.view_status_bar);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    public View getStatusBarView() {
        return mStatusBarView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
