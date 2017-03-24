package com.z.ice.apquitsmoke.ui.main;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.orhanobut.logger.Logger;
import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.app.Constants;
import com.z.ice.apquitsmoke.base.BaseActivity;
import com.z.ice.zutilslib.util.ActivityManagerUtil;

import java.util.Random;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.drawer_nv)
    NavigationView mDrawerNv;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolBar, "首页");
        Logger.d(ActivityManagerUtil.currentActivity().getLocalClassName());
        //侧滑菜单
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状态
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerNv.getHeaderView(0).setBackgroundResource(Constants.headerImgs[new Random().nextInt(Constants.headerImgs.length)]);
    }

}
