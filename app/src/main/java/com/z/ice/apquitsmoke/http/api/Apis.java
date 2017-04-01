package com.z.ice.apquitsmoke.http.api;

import com.z.ice.apquitsmoke.bean.UserBean;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * desc: Apis
 * date: 2017/4/1
 * author: Zice
 */
public interface Apis {

    String ApiUrl = "http://192.168.1.114:55566";

    //注册
    @POST("/api/v1/register")
    Observable<UserBean> signToRegister(@Query("userPhone") String userPhone, @Query("password") String password);
}
