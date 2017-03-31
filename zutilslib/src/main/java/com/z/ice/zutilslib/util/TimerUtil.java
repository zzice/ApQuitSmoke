package com.z.ice.zutilslib.util;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * desc: TimerUtil
 * date: 2017/3/31
 * author: Zice
 */
public class TimerUtil extends CountDownTimer {

    Button mButton;

    /**
     * @param millisInFuture    表示以毫秒为单位 倒计时的总数
     * @param countDownInterval 表示 间隔 多少微秒 调用一次 onTick 方法
     */
    public TimerUtil(long millisInFuture, long countDownInterval, Button button) {
        super(millisInFuture, countDownInterval);
        mButton = button;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mButton.setText("倒计时：" + millisUntilFinished / 1000);
        mButton.setEnabled(false);
    }

    @Override
    public void onFinish() {
        mButton.setText("重发验证码");
        mButton.setEnabled(true);
    }
}
