package com.z.ice.apquitsmoke.ui.sign;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.adapter.SignPagerAdapter;
import com.z.ice.apquitsmoke.base.BaseActivity;
import com.z.ice.apquitsmoke.di.presenter.LaunchPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.LaunchContract;

import butterknife.BindView;

public class SignActivity extends BaseActivity<LaunchPresenter> implements LaunchContract.View{

    @BindView(R.id.sign_tab_layout)
    TabLayout mSignTabLayout;
    @BindView(R.id.sign_fm_vp)
    ViewPager mSignFmVp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected void initEventAndData() {
        SignPagerAdapter signPagerAdapter = new SignPagerAdapter(getSupportFragmentManager());
        mSignFmVp.setAdapter(signPagerAdapter);
        mSignTabLayout.setupWithViewPager(mSignFmVp);
    }

    @Override
    public void showError(String msg) {

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
