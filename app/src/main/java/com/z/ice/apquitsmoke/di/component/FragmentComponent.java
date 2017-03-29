package com.z.ice.apquitsmoke.di.component;

import android.app.Activity;

import com.z.ice.apquitsmoke.di.module.FragmentModule;
import com.z.ice.apquitsmoke.di.scope.FragmentScope;
import com.z.ice.apquitsmoke.ui.main.SelectModeFragment;
import com.z.ice.apquitsmoke.ui.sign.LoginFragment;

import dagger.Component;

/**
 * desc: FragmentComponent.java
 * date: 2017/3/28
 * author: Zice
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(LoginFragment loginFragment);

    void inject(SelectModeFragment selectModeFragment);

//    void inject(ThemeFragment themeFragment);
//
//    void inject(SectionFragment sectionFragment);
//
//    void inject(HotFragment hotFragment);
//
//    void inject(CommentFragment longCommentFragment);
//
//    void inject(TechFragment techFragment);
//
//    void inject(GirlFragment girlFragment);
//
//    void inject(LikeFragment likeFragment);
//
//    void inject(WechatMainFragment wechatMainFragment);
//
//    void inject(SettingFragment settingFragment);
//
//    void inject(GoldMainFragment goldMainFragment);
//
//    void inject(GoldPagerFragment goldPagerFragment);
//
//    void inject(VtexPagerFragment vtexPagerFragment);
}
