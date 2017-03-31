package com.z.ice.apquitsmoke.ui.sign;


import android.widget.Button;

import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.base.BaseFragment;
import com.z.ice.apquitsmoke.di.presenter.LoginPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.LoginContract;
import com.z.ice.apquitsmoke.ui.main.MainActivity;
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

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showShortMessage(String msg) {
        ToastUtil.showShortToast(getActivity(),msg);
    }

    @Override
    public void isShowLoadingView(boolean isShow) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void jumpToMain() {
        openAndCloseActivity(MainActivity.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.sign_login_btn)
    public void signLoginJumpActivity() {
        mPresenter.setLoginAction();
    }
}
