package com.z.ice.apquitsmoke.ui.main;

import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;

import com.orhanobut.logger.Logger;
import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.app.Constants;
import com.z.ice.apquitsmoke.base.BaseActivity;
import com.z.ice.apquitsmoke.di.presenter.LaunchPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.LaunchContract;
import com.z.ice.zutilslib.util.ActivityManagerUtil;

import java.util.Random;

import butterknife.BindView;

public class MainActivity extends BaseActivity<LaunchPresenter> implements LaunchContract.View {

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.drawer_nv)
    NavigationView mDrawerNv;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    ActionBarDrawerToggle mDrawerToggle;
//    @BindView(R.id.fl_main_content)
//    FrameLayout mFlMainContent;


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
        mDrawerNv.getChildAt(0).setVerticalScrollBarEnabled(false);
        mDrawerNv.getHeaderView(0).setBackgroundResource(Constants.headerImgs[new Random().nextInt(Constants.headerImgs.length)]);
        SelectModeFragment selectModeFragment = new SelectModeFragment();
        loadRootFragment(R.id.fl_main_content, selectModeFragment);
        //判断是否初次进入应用
        //dialog问卷调查 烟龄 每日抽烟数量 价格 模式选择
        //tips 烟龄 每日抽烟数量 价格
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //模式选择
        builder.setView(R.layout.smoke_info_dialog_layout);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showSmokePlanDialog();
            }
        });
        builder.create().show();
        //初始化主页
    }

    /**
     * 展示抽烟模式选择对话框
     */
    private void showSmokePlanDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setView(R.layout.smoke_plan_dialog_layout);
        builder1.show();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showShortMessage(String msg) {

    }

    @Override
    public void isShowLoadingView(boolean isShow) {

    }

    @Override
    public void setVersionNameAndCopyright(String versionName, String copyRight) {

    }

    @Override
    public void jumpToLogin() {

    }

    @Override
    public void jumpToMain() {

    }

    @Override
    public void startLaunchAnimation() {

    }
}
