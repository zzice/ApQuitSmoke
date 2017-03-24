package com.z.ice.apquitsmoke.ui.launch;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.z.ice.apquitsmoke.R;
import com.z.ice.apquitsmoke.base.BaseActivity;
import com.z.ice.apquitsmoke.ui.main.MainActivity;

import butterknife.BindView;

public class LaunchActivity extends BaseActivity {

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

    }

    @Override
    protected void initEventAndData() {
        AssetManager mgr = getAssets();//得到AssetManager
        Typeface tf = Typeface.createFromAsset(mgr, "fonts/Slabo27px-Regular.ttf");//根据路径得到Typeface
        mLaunchVersionTv.setTypeface(tf);//设置字体
        mLaunchAppCopyright.setTypeface(tf);
        mLaunchVersionTv.setText("v1.0.0");
        mLaunchAppCopyright.setText(getResources().getString(R.string.copyright));
        //进行缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        //动画播放完成后保持形状
        scaleAnimation.setFillAfter(true);
        mLaunchBgIv.startAnimation(scaleAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        },3000);
    }

}
