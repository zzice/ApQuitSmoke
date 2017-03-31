package com.z.ice.apquitsmoke.di.presenter;

import com.z.ice.apquitsmoke.base.RxPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.LoginContract;
import com.z.ice.apquitsmoke.di.scope.FragmentScope;

import javax.inject.Inject;

/**
 * desc: LoginPresenter.java
 * date: 2017/3/29
 * author: Zice
 */
@FragmentScope
public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {


    @Inject
    LoginPresenter() {
    }


    @Override
    public void setLoginAction() {
        mView.showShortMessage("登录成功");
        mView.jumpToMain();
    }
}
