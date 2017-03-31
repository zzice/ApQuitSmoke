package com.z.ice.apquitsmoke.di.presenter;

import android.os.Handler;
import android.os.Message;

import com.orhanobut.logger.Logger;
import com.z.ice.apquitsmoke.base.RxPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.RegisterContract;
import com.z.ice.apquitsmoke.di.scope.FragmentScope;

import org.json.JSONObject;

import java.util.Map;

import javax.inject.Inject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * desc: RegisterPresenter
 * date: 2017/3/30
 * author: Zice
 */
@FragmentScope
public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements RegisterContract.Presenter {

    @Inject
    RegisterPresenter() {
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
        SMSSDK.registerEventHandler(eventHandler); //注册短信回调
        SMSSDK.getVerificationCode("+86", phoneNumber);
    }

    @Override
    public void verifyPhoneCode(String phoneNumber, String code) {
        mView.isShowLoadingView(true);
        SMSSDK.submitVerificationCode("+86", phoneNumber, code);
    }

    @Override
    public void submitRegisterInfo(Map<String, String> map) {
        String phoneNumber = map.get("phone");
        String code = map.get("password");
        mView.jumpToMain();
        mView.isShowLoadingView(false);
    }


}
