package com.z.ice.apquitsmoke.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.z.ice.apquitsmoke.ui.sign.LoginFragment;
import com.z.ice.apquitsmoke.ui.sign.RegisterFragment;

/**
 * desc: SignPagerAdapter
 * date: 2017/3/28
 * author: Zice
 */
public class SignPagerAdapter extends FragmentPagerAdapter {

    //登录、注册
    private Fragment[] mFragments = {new LoginFragment(), new RegisterFragment()};
    private CharSequence[] titles = {"登录", "注册"};

    public SignPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return 2;
    }

    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
