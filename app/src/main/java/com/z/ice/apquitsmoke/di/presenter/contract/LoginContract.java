package com.z.ice.apquitsmoke.di.presenter.contract;

import com.z.ice.apquitsmoke.base.BasePresenter;
import com.z.ice.apquitsmoke.base.BaseView;

/**
 * desc: LoginContract.java
 * date: 2017/3/29
 * author: Zice
 */
public interface LoginContract {

    interface View extends BaseView {

        void showProgress();

        void showSuccess();

        void showToastMessage(String message);

        void jumpToMain();

    }

    interface Presenter extends BasePresenter<View> {

        void setLoginAction();

    }

}
