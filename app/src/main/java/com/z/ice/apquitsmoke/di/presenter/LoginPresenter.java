package com.z.ice.apquitsmoke.di.presenter;

import com.orhanobut.logger.Logger;
import com.z.ice.apquitsmoke.base.RxPresenter;
import com.z.ice.apquitsmoke.bean.UserBean;
import com.z.ice.apquitsmoke.di.presenter.contract.LoginContract;
import com.z.ice.apquitsmoke.di.scope.FragmentScope;
import com.z.ice.apquitsmoke.http.RetrofitHelper;
import com.z.ice.apquitsmoke.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * desc: LoginPresenter.java
 * date: 2017/3/29
 * author: Zice
 */
@FragmentScope
public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public LoginPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void setLoginAction(String phoneNumber,String password) {
        mView.isShowLoadingView(true);
        Subscription subscription = mRetrofitHelper.fetchUserLoginInfo(phoneNumber, password)
                .compose(RxUtil.<UserBean>rxSchedulerHelper())
                .subscribe(new Action1<UserBean>() {
                    @Override
                    public void call(UserBean userBean) {
                        if (userBean.isSuccess()) {
                            Logger.d("token:" + userBean.getToken());
                            mView.showShortMessage("登录成功");
                            mView.jumpToMain(userBean.getToken(),userBean);
                        }else {
                            mView.showError(userBean.getError());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.d("error:"+throwable);
                        mView.showError("当前操作出现错误,请稍后重试");
                    }
                });
        addSubscrebe(subscription);
        mView.isShowLoadingView(false);
    }
}
