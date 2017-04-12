package com.z.ice.apquitsmoke.ui.main;

import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.app.Constants;
import com.z.ice.apquitsmoke.base.BaseActivity;
import com.z.ice.apquitsmoke.di.presenter.MainPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.MainContract;
import com.z.ice.zutilslib.util.SpUtils;

import java.util.Random;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.drawer_nv)
    NavigationView mDrawerNv;
    @BindView(R.id.drawer_layout)

    DrawerLayout mDrawerLayout;

    ActionBarDrawerToggle mDrawerToggle;
    private CtrlSmokeFragment mCtrlSmokeFragment;
    private QuitSmokeFragment mQuitSmokeFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolBar, "首页");
        //侧滑菜单
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar,
                R.string.drawer_open, R.string.drawer_close);
        //初始化状态
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerNv.getChildAt(0).setVerticalScrollBarEnabled(false);
        mDrawerNv.getHeaderView(0).setBackgroundResource(Constants.headerImgs[new Random().nextInt(Constants.headerImgs.length)]);
        //判断是否初始化
        boolean isInit = (boolean) SpUtils.get(MainActivity.this, "isInit", false);
        //if 初次进入应用，需调研数据，选择模式 弹窗
        if (!isInit) {
            showSmokeInfoDialog();
        } else {
            //初始化模式
            int mode = (int) SpUtils.get(MainActivity.this, "mode", 0);
            select(mode);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_toolbar_menu, menu);
        return true;
    }

    private void showSmokeInfoDialog() {
        //dialog问卷调查 烟龄 每日抽烟数量 价格 模式选择
        //tips 烟龄 每日抽烟数量 价格
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        //模式选择
        builder.setView(R.layout.smoke_info_dialog_layout);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showSmokePlanDialog();
            }
        });
        builder.create().show();
    }

    /**
     * 模式选择对话框
     */
    private void showSmokePlanDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = View.inflate(MainActivity.this, R.layout.smoke_plan_dialog_layout, null);
        Button dCtrlBtn = (Button) view.findViewById(R.id.d_ctrl_btn);
        Button dQuitBtn = (Button) view.findViewById(R.id.d_quit_btn);
        builder.setView(view);
        builder.setCancelable(false);
        final AlertDialog dialog = builder.create();
        //上传信息到服务器
        dCtrlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //加载控烟模式Fragment
                SpUtils.put(MainActivity.this, "isInit", true);
                SpUtils.put(MainActivity.this, "mode", 0);
                select(0);
            }
        });
        dQuitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //加载戒烟模式Fragment
                SpUtils.put(MainActivity.this, "isInit", true);
                SpUtils.put(MainActivity.this, "mode", 1);
                select(1);
            }
        });
        dialog.show();
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

    /**
     * 显示fragment
     *
     * @param i 角标position
     */
    private void select(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (i) {
            case 0:
                if (mCtrlSmokeFragment == null) {
                    mCtrlSmokeFragment = new CtrlSmokeFragment();
                    ft.add(R.id.fl_main_content, mCtrlSmokeFragment);
                } else {
                    ft.show(mCtrlSmokeFragment);
                }
                break;
            case 1:
                if (mQuitSmokeFragment == null) {
                    mQuitSmokeFragment = new QuitSmokeFragment();
                    ft.add(R.id.fl_main_content, mQuitSmokeFragment);
                } else {
                    ft.show(mQuitSmokeFragment);
                }
                break;
        }
        ft.commit();
    }

    /**
     * 隐藏fragment
     *
     * @param ft FragmentTransaction
     */
    private void hideFragment(FragmentTransaction ft) {
        if (mCtrlSmokeFragment != null) ft.hide(mCtrlSmokeFragment);

        if (mQuitSmokeFragment != null) ft.hide(mQuitSmokeFragment);
    }

    /**
     * 返回键 不退出应用 保留应用进程 类似Home键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
