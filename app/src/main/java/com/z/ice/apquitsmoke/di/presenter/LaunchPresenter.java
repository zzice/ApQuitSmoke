package com.z.ice.apquitsmoke.di.presenter;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;

import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.base.RxPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.LaunchContract;
import com.z.ice.apquitsmoke.di.scope.ActivityScope;

import javax.inject.Inject;

/**
 * desc: LaunchPresenter
 * date: 2017/3/27
 * author: Zice
 */
@ActivityScope
public class LaunchPresenter extends RxPresenter<LaunchContract.View> implements LaunchContract.Presenter {
    private Activity mActivity;

    @Inject
    LaunchPresenter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public void getVersionName() {
        String versionName;
        try {
            PackageManager pm = mActivity.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(mActivity.getPackageName(), PackageManager.GET_ACTIVITIES);
            versionName = "v" + pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            versionName = "v0.0.0";
        }
        mView.setVersionNameAndCopyright(versionName, mActivity.getResources().getString(R.string.copyright));
        mView.startLaunchAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.jumpToLogin();
            }
        }, 3000);
    }

}
