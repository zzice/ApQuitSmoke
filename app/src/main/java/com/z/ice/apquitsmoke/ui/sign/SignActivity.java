package com.z.ice.apquitsmoke.ui.sign;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.adapter.SignPagerAdapter;
import com.z.ice.apquitsmoke.base.SimpleBaseActivity;

import butterknife.BindView;
/**
 * desc: 注册登录页
 * date: 2017/3/29
 * author: Zice
 */
public class SignActivity extends SimpleBaseActivity{

    @BindView(R.id.sign_tab_layout)
    TabLayout mSignTabLayout;
    @BindView(R.id.sign_fm_vp)
    ViewPager mSignFmVp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign;
    }


    @Override
    protected void initEventAndData() {
        SignPagerAdapter signPagerAdapter = new SignPagerAdapter(getSupportFragmentManager());
        mSignFmVp.setAdapter(signPagerAdapter);
        mSignTabLayout.setupWithViewPager(mSignFmVp);
    }

}
