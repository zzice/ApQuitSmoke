package com.z.ice.apquitsmoke.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.z.ice.apquitsmoke.app.App;
import com.z.ice.apquitsmoke.di.component.ActivityComponent;
import com.z.ice.apquitsmoke.di.component.DaggerActivityComponent;
import com.z.ice.apquitsmoke.di.module.ActivityModule;
import com.z.ice.zutilslib.util.ActivityManagerUtil;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * desc: 基类Activity
 * date: 2017/3/22
 * author: Zice
 */
public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {
    @Inject
    protected T mPresenter;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //绑定
        mUnbinder = ButterKnife.bind(this);
        initInject();
        Logger.d(this);
        if (mPresenter != null)
            mPresenter.attachView(this);
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
                onBackPressedSupport();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        //解除绑定
        mUnbinder.unbind();
        ActivityManagerUtil.finishActivity(this);
    }

    protected ActivityComponent getActivityComponent() {
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initInject();

    protected abstract void initEventAndData();

    /**
     * 打开指定Activity
     *
     * @param cls Activity Class
     */
    protected void openActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void openAndCloseActivity(Class<?> cls, Bundle bundle) {
        openActivity(cls, bundle);
        finish();
    }

    /**
     * 打开指定Activity，并关闭当前Activity
     *
     * @param cls Activity Class
     */
    protected void openAndCloseActivity(Class<?> cls) {
        openActivity(cls);
        finish();
    }

}
