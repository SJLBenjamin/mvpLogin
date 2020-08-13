package com.example.mvplogin.login;

import com.example.mvplogin.bean.LoginAndRegisterBean;
import com.example.mvplogin.network.ApiClient;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * model提供数据
 */
public class LoginModel {

    /**
     * 登录
     * @param username  登录账号
     * @param password  登录密码
     * @param loginIpl  登录的回调接口
     */
    public void login(String username, String password, final LoginIpl loginIpl){

        final Observable<LoginAndRegisterBean> login = ApiClient.apiClient.wanAndroidApiService.login(username, password);

       /*
        subscribeOn 订阅者,被观察者
        observeOn  观察者
        */
        login.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<LoginAndRegisterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginAndRegisterBean loginAndRegisterBean) {
                if(loginAndRegisterBean.getErrorCode()==0){//登录成功
                    loginIpl.LoginSuccess(loginAndRegisterBean);
                }else {//登录失败
                    loginIpl.LoginFail();
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
