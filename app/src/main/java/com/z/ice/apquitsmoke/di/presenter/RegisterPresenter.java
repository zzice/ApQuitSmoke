package com.z.ice.apquitsmoke.di.presenter;

import android.os.Handler;
import android.os.Message;

import com.orhanobut.logger.Logger;
import com.z.ice.apquitsmoke.base.RxPresenter;
import com.z.ice.apquitsmoke.bean.UserBean;
import com.z.ice.apquitsmoke.di.presenter.contract.RegisterContract;
import com.z.ice.apquitsmoke.di.scope.FragmentScope;
import com.z.ice.apquitsmoke.http.RetrofitHelper;
import com.z.ice.apquitsmoke.util.RxUtil;

import org.json.JSONObject;

import java.util.Map;

import javax.inject.Inject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import rx.Subscription;
import rx.functions.Action1;

/**
 * desc: RegisterPresenter
 * date: 2017/3/30
 * author: Zice
 */
@FragmentScope
public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements RegisterContract.Presenter {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public RegisterPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getVerificationCode(String phoneNumber) {
        mView.isTimerAction(true);
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE:
                        Logger.d("提交验证码成功");
                        mView.verifyCodeSuccess();
                        break;
                    case SMSSDK.EVENT_GET_VERIFICATION_CODE:
                        Logger.d("获取验证码成功");
                        mView.showShortMessage("获取验证码成功");
                        break;
                    case 101:
                        mView.isShowLoadingView(false);
                        mView.isTimerAction(false);
                        String jsonData = ((Throwable) msg.obj).getMessage();
                        try {
                            JSONObject object = new JSONObject(jsonData);
                            mView.showShortMessage(object.getString("detail"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        };
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    handler.sendEmptyMessage(event);
                } else {
                    Message message = new Message();
                    message.obj = data;
                    message.what = 101;
                    handler.sendMessage(message);
                }
            }
        };
        //注册短信回调
        SMSSDK.registerEventHandler(eventHandler);
        //获取短信
        SMSSDK.getVerificationCode("+86", phoneNumber);
    }

    @Override
    public void verifyPhoneCode(String phoneNumber, String code) {
        mView.isShowLoadingView(true);
        //验证短信验证码
        SMSSDK.submitVerificationCode("+86", phoneNumber, code);
    }

    @Override
    public void submitRegisterInfo(Map<String, String> map) {
        String phoneNumber = map.get("phone");
        String password = map.get("password");
        Subscription subscription = mRetrofitHelper.fetchUserInfo(phoneNumber, password)
                .compose(RxUtil.<UserBean>rxSchedulerHelper())
                .subscribe(new Action1<UserBean>() {
                    @Override
                    public void call(UserBean userBean) {
                        if (userBean.isSuccess()) {
                            Logger.d("token:" + userBean.getToken());
                            mView.showShortMessage("注册成功");
                            mView.jumpToMain(userBean.getToken(),userBean);
                        }else {
                            mView.showError(userBean.getError());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.d("error:"+throwable);
                        mView.showError(throwable.getMessage());
                    }
                });
        addSubscrebe(subscription);
        mView.isShowLoadingView(false);
        SMSSDK.unregisterAllEventHandler();
    }


}
