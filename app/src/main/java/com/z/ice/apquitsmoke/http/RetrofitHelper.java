package com.z.ice.apquitsmoke.http;

import com.z.ice.apquitsmoke.bean.UserBean;
import com.z.ice.apquitsmoke.http.api.Apis;

import rx.Observable;

/**
 * desc: RetrofitHelper
 * date: 2017/4/1
 * author: Zice
 */
public class RetrofitHelper {

    private Apis mApis;

    public RetrofitHelper(Apis apis) {
        mApis = apis;
    }

    public Observable<UserBean> fetchUserInfo(String phoneNum, String password) {
        return mApis.signToRegister(phoneNum, password);
    }
}
