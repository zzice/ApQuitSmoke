package com.z.ice.apquitsmoke.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.z.ice.zutilslib.util.ActivityManagerUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * desc: 基类Activity
 * date: 2017/3/22
 * author: Zice
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //绑定
        mUnbinder = ButterKnife.bind(this);
        initInject();
        ActivityManagerUtil.addActivity(this);
        initEventAndData();
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //https://github.com/YoKeyword/Fragmentation/
                //onBackPressedSupport();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        mUnbinder.unbind();
        ActivityManagerUtil.finishActivity(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initInject();

    protected abstract void initEventAndData();
}
