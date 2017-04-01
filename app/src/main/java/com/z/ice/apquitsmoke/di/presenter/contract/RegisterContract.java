package com.z.ice.apquitsmoke.di.presenter.contract;

import com.z.ice.apquitsmoke.base.BasePresenter;
import com.z.ice.apquitsmoke.base.BaseView;
import com.z.ice.apquitsmoke.bean.UserBean;

import java.util.Map;

/**
 * desc: RegisterContract
 * date: 2017/3/30
 * author: Zice
 */
public interface RegisterContract {

    interface View extends BaseView {

        void jumpToMain(UserBean userBean);

        /**
         * 启动或关闭倒计时
         *
         * @param state true表示启动,false表示停止
         */
        void isTimerAction(boolean state);

        // 成功验证验证码
        void verifyCodeSuccess();

    }

    interface Presenter extends BasePresenter<View> {

        void getVerificationCode(String phoneNumber);

        void verifyPhoneCode(String phoneNumber, String code);

        void submitRegisterInfo(Map<String, String> map);
    }

}
