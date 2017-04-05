package com.z.ice.apquitsmoke.ui.sign;


import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.blankj.utilcode.util.RegexUtils;
import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.base.BaseFragment;
import com.z.ice.apquitsmoke.bean.UserBean;
import com.z.ice.apquitsmoke.di.presenter.LoginPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.LoginContract;
import com.z.ice.apquitsmoke.ui.main.MainActivity;
import com.z.ice.zutilslib.util.SpUtils;
import com.z.ice.zutilslib.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * desc: 登录Fragment
 * date: 2017/3/29
 * author: Zice
 */
public class LoginFragment extends BaseFragment<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.sign_login_btn)
    Button mSignLoginBtn;
    @BindView(R.id.login_phone_et)
    EditText mLoginPhoneEt;
    @BindView(R.id.login_password_et)
    EditText mLoginPasswordEt;
    @BindView(R.id.rememb_psw_cb)
    CheckBox mRemembPswCb;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initEventAndData() {
        //记住密码
        boolean remembPswCheck = (boolean) SpUtils.get(getActivity(), "remembPswCheck", false);
        if (remembPswCheck && SpUtils.contains(getActivity(), "phone") && SpUtils.contains(getActivity(), "password")) {
            mRemembPswCb.setChecked(remembPswCheck);
            mLoginPhoneEt.setText((String) SpUtils.get(getActivity(), "phone", ""));
            mLoginPasswordEt.setText((String) SpUtils.get(getActivity(), "password", ""));
        }
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
    public void jumpToMain(String token, UserBean userBean) {
        //移除sp数据存储
        SpUtils.clear(getActivity());
        SpUtils.put(getActivity(), "token", token);
        //是否记住密码
        if (mRemembPswCb.isChecked()) {
            SpUtils.put(getActivity(), "remembPswCheck", true);
            String loginPhoneString = getEtTextString(mLoginPhoneEt);
            String loginPwdString = getEtTextString(mLoginPasswordEt);
            SpUtils.put(getActivity(), "phone", loginPhoneString);
            SpUtils.put(getActivity(), "password", loginPwdString);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBean);
        openAndCloseActivity(MainActivity.class);
    }


    @OnClick(R.id.sign_login_btn)
    public void signLoginJumpActivity() {
        if (isNullOrRegex()) {
            String loginPhoneString = getEtTextString(mLoginPhoneEt);
            String loginPwdString = getEtTextString(mLoginPasswordEt);
            mPresenter.setLoginAction(loginPhoneString, loginPwdString);
        }
    }

    private boolean isNullOrRegex() {
        if (isEditTextValueEmpty(mLoginPhoneEt)) {
            showShortMessage("尚未填写用户手机号码");
        } else if (!RegexUtils.isMobileExact(getEtTextString(mLoginPhoneEt))) {
            showShortMessage("手机号码格式不正确");
        } else if (isEditTextValueEmpty(mLoginPasswordEt)) {
            showShortMessage("尚未填写用户密码");
        } else {
            return true;
        }
        return false;
    }

}
