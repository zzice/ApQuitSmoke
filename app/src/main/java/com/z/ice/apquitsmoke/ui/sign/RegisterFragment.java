package com.z.ice.apquitsmoke.ui.sign;


import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.blankj.utilcode.util.RegexUtils;
import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.app.Constants;
import com.z.ice.apquitsmoke.base.BaseFragment;
import com.z.ice.apquitsmoke.di.presenter.RegisterPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.RegisterContract;
import com.z.ice.apquitsmoke.ui.main.MainActivity;
import com.z.ice.zutilslib.util.TimerUtil;
import com.z.ice.zutilslib.util.ToastUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.smssdk.SMSSDK;

/**
 * desc: RegisterFragment.java
 * date: 2017/3/30
 * author: Zice
 */
public class RegisterFragment extends BaseFragment<RegisterPresenter> implements RegisterContract.View {


    @BindView(R.id.register_phone_et)
    EditText mRegisterPhoneEt;
    @BindView(R.id.register_verify_et)
    EditText mRegisterVerifyEt;
    @BindView(R.id.get_verify_code_btn)
    Button mGetVerifyCodeBtn;
    @BindView(R.id.register_password_et)
    EditText mRegisterPasswordEt;
    @BindView(R.id.rememb_psw_cb)
    CheckBox mRemembPswCb;
    @BindView(R.id.register_submit_btn)
    Button mRegisterSubmitBtn;

    TimerUtil timerUtil;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initEventAndData() {
        //初始化Mob短信 SMSSDK
        SMSSDK.initSDK(getActivity(), Constants.MOB_SMS_KEY, Constants.MOB_SMS_SECRET);
    }

    @Override
    public void showError(String msg) {
        ToastUtil.showShortToast(getActivity(), msg);
    }

    @Override
    public void showShortMessage(String msg) {
        ToastUtil.showShortToast(getActivity(), msg);
    }

    @Override
    public void isShowLoadingView(boolean isShow) {
        assert mProgressDialog != null;
        if (isShow && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        } else {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void jumpToMain() {
        openAndCloseActivity(MainActivity.class);
    }

    @Override
    public void isTimerAction(boolean state) {
        if (timerUtil == null) {
            timerUtil = new TimerUtil(30000, 1000, mGetVerifyCodeBtn);
        }
        if (state) {
            timerUtil.start();
        } else {
            timerUtil.onFinish();
            timerUtil.cancel();
        }
    }

    @Override
    public void verifyCodeSuccess() {
        if (isNullOrOther()) {
            HashMap<String, String> registerMap = new HashMap<>();
            registerMap.put("phone", getEtTextString(mRegisterPhoneEt));
            registerMap.put("password", getEtTextString(mRegisterPasswordEt));
            mPresenter.submitRegisterInfo(registerMap);
        }
    }


    @OnClick({R.id.get_verify_code_btn, R.id.register_submit_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get_verify_code_btn:
                if (isEditTextValueEmpty(mRegisterPhoneEt)) {
                    showShortMessage("尚未输入手机号");
                } else if (!RegexUtils.isMobileExact(getEtTextString(mRegisterPhoneEt))) {
                    showShortMessage("请检查手机号码格式");
                } else {
                    mPresenter.getVerificationCode(getEtTextString(mRegisterPhoneEt));
                }
                break;
            case R.id.register_submit_btn:
                if (isNullOrOther()) {
                    //验证手机验证码
                    mPresenter.verifyPhoneCode(getEtTextString(mRegisterPhoneEt), getEtTextString(mRegisterVerifyEt));
                }
                break;
        }
    }

    private String getEtTextString(EditText et) {
        return et.getText().toString().trim();
    }

    /**
     * 判断控件 值非空或满足正则条件
     *
     * @return true or false
     */
    private boolean isNullOrOther() {
        if (isEditTextValueEmpty(mRegisterPhoneEt)) {
            showShortMessage("请填写手机号");
        } else if (!RegexUtils.isMobileExact(getEtTextString(mRegisterPhoneEt))) {
            showShortMessage("请检查手机号码格式");
        } else if (isEditTextValueEmpty(mRegisterVerifyEt)) {
            showShortMessage("请填写验证码");
        } else if (isEditTextValueEmpty(mRegisterPasswordEt)) {
            showShortMessage("请填写密码");
        } else if (!mRemembPswCb.isChecked()) {
            showShortMessage("需勾选同意注册协议方可注册");
        } else {
            return true;
        }
        return false;
    }
}
