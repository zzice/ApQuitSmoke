package com.z.ice.apquitsmoke.ui.launch;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.base.BaseActivity;
import com.z.ice.apquitsmoke.di.presenter.LaunchPresenter;
import com.z.ice.apquitsmoke.di.presenter.contract.LaunchContract;
import com.z.ice.apquitsmoke.ui.main.MainActivity;
import com.z.ice.apquitsmoke.ui.sign.SignActivity;

import butterknife.BindView;

public class LaunchActivity extends BaseActivity<LaunchPresenter> implements LaunchContract.View {

    @BindView(R.id.launch_version_tv)
    TextView mLaunchVersionTv;
    @BindView(R.id.launch_app_copyright)
    TextView mLaunchAppCopyright;
    @BindView(R.id.launch_bg_iv)
    ImageView mLaunchBgIv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_launch;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getVersionName();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void setVersionNameAndCopyright(String versionName, String copyRight) {
        AssetManager mgr = getAssets();//得到AssetManager
        Typeface tf = Typeface.createFromAsset(mgr, "fonts/Slabo27px-Regular.ttf");//根据路径得到Typeface
        mLaunchVersionTv.setTypeface(tf);//设置字体
        mLaunchAppCopyright.setTypeface(tf);
        mLaunchVersionTv.setText(versionName);
        mLaunchAppCopyright.setText(copyRight);
    }

    @Override
    public void jumpToLogin() {
        openAndCloseActivity(SignActivity.class);
    }

    @Override
    public void jumpToMain() {
        openAndCloseActivity(MainActivity.class);
    }

    @Override
    public void startLaunchAnimation() {
        //进行缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        //动画播放完成后保持形状
        scaleAnimation.setFillAfter(true);
        mLaunchBgIv.startAnimation(scaleAnimation);
    }
}
