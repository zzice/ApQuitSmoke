package com.z.ice.apquitsmoke.di.presenter.contract;

import com.z.ice.apquitsmoke.base.BasePresenter;
import com.z.ice.apquitsmoke.base.BaseView;
import com.z.ice.apquitsmoke.bean.UserBean;

/**
 * desc: LoginContract.java
 * date: 2017/3/29
 * author: Zice
 */
public interface LoginContract {

    interface View extends BaseView {

        void jumpToMain(String token, UserBean userBean);

    }

    interface Presenter extends BasePresenter<View> {

        void setLoginAction(String phoneNumber, String password);

    }

}
