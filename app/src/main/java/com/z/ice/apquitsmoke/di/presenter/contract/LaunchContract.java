package com.z.ice.apquitsmoke.di.presenter.contract;

import com.z.ice.apquitsmoke.base.BasePresenter;
import com.z.ice.apquitsmoke.base.BaseView;

/**
 * desc: LaunchContract
 * date: 2017/3/27
 * author: Zice
 */
public interface LaunchContract {

    interface View extends BaseView {

        void setVersionNameAndCopyright(String versionName, String copyRight);

        void jumpToLogin();

        void jumpToMain();

        void startLaunchAnimation();
    }

    interface Presenter extends BasePresenter<View> {

        void getVersionName();

    }

}
