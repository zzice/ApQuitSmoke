package com.z.ice.apquitsmoke.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.app.App;
import com.z.ice.apquitsmoke.di.component.DaggerFragmentComponent;
import com.z.ice.apquitsmoke.di.component.FragmentComponent;
import com.z.ice.apquitsmoke.di.module.FragmentModule;
import com.z.ice.zutilslib.widget.CustomProgressDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * desc: BaseFragment MVP Fragment基类
 * date: 2017/3/28
 * author: Zice
 */
public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment implements BaseView {

    @Inject
    protected T mPresenter;
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    private Unbinder mUnBinder;
    protected boolean isInited = false;
    protected CustomProgressDialog mProgressDialog;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        initInject();
        mProgressDialog = new CustomProgressDialog(getActivity(), R.style.CustomDialog);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mUnBinder = ButterKnife.bind(this, view);
        if (savedInstanceState == null) {
            if (!isHidden()) {
                isInited = true;
                initEventAndData();
            }
        } else {
            onLazyInitView(savedInstanceState);
//            if (!isSupportHidden()) {
           /* if (!isHidden()) {
                isInited = true;
                initEventAndData();
            }*/
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!isInited && !hidden) {
            isInited = true;
            initEventAndData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

    protected abstract void initInject();

    protected abstract int getLayoutId();

    protected abstract void initEventAndData();

    /**
     * 打开指定Activity
     *
     * @param cls Activity Class
     */
    protected void openActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void openAndCloseActivity(Class<?> cls, Bundle bundle) {
        openActivity(cls, bundle);
        getActivity().finish();
    }

    /**
     * 打开指定Activity，并关闭当前Activity
     *
     * @param cls Activity Class
     */
    protected void openAndCloseActivity(Class<?> cls) {
        openActivity(cls);
        getActivity().finish();
    }

    public boolean isEditTextValueEmpty(EditText et) {
        return TextUtils.isEmpty(et.getText().toString().trim());
    }
}