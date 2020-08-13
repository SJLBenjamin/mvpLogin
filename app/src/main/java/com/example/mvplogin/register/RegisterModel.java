package com.example.mvplogin.register;

import com.example.mvplogin.bean.LoginAndRegisterBean;
import com.example.mvplogin.network.ApiClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterModel {

    /** 提供注册的信息
     * @param username 账号
     * @param password 密码
     * @param rePassword 确认密码
     * @param registerIpl  回调接口
     */
    public void register(String username, String password, String rePassword, final RegisterIpl registerIpl){
        Observable<LoginAndRegisterBean> register = ApiClient.apiClient.wanAndroidApiService.register(username, password, rePassword);
        register.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<LoginAndRegisterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginAndRegisterBean loginAndRegisterBean) {
                if(loginAndRegisterBean.getErrorCode()==0){//注册成功
                    registerIpl.registerSuccess(loginAndRegisterBean);
                }else {//注册失败
                    registerIpl.registerFail();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
