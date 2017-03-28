package com.z.ice.apquitsmoke.di.presenter.contract;

import com.z.ice.apquitsmoke.base.BasePresenter;
import com.z.ice.apquitsmoke.base.BaseView;

/**
 * desc: SignContract
 * date: 2017/3/28
 * author: Zice
 */
public interface SignContract {

    interface View extends BaseView {

        void showProgress();

        void showSuccess();

        void showToastMessage(String message);

    }

    interface Presenter extends BasePresenter<View> {

        void jumpToMain();

        void getVerifyCode();

        void setLoginAction();

        void setRegisterAction();
    }

}
