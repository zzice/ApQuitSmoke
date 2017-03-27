package com.z.ice.apquitsmoke.base;

/**
 * desc: BasePresenter
 * date: 2017/3/27
 * author: Zice
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
