package com.z.ice.apquitsmoke.di.presenter;

import com.z.ice.apquitsmoke.base.RxPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.SignContract;
import com.z.ice.apquitsmoke.di.scope.ActivityScope;

import javax.inject.Inject;

/**
 * desc: SignPresenter
 * date: 2017/3/28
 * author: Zice
 */
@ActivityScope
public class SignPresenter extends RxPresenter<SignContract.View> implements SignContract.Presenter {


    @Inject
    SignPresenter() {
    }

    @Override
    public void jumpToMain() {

    }

    @Override
    public void getVerifyCode() {

    }

    @Override
    public void setLoginAction() {

    }

    @Override
    public void setRegisterAction() {

    }
}
