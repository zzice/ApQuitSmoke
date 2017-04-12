package com.z.ice.apquitsmoke.di.presenter;

import com.z.ice.apquitsmoke.base.RxPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.MainContract;

import javax.inject.Inject;

/**
 * desc: Main
 * date: 2017/4/11
 * author: Zice
 */
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    MainPresenter() {
    }

}
