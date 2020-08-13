package com.example.mvplogin.login;

import com.example.mvplogin.bean.LoginAndRegisterBean;

/**
 * 登录的回调接口
 */
public interface LoginIpl {

    /**登录成功回调的接口方法
     * @param loginAndRegisterBean  请求的值
     */
    public void LoginSuccess(LoginAndRegisterBean loginAndRegisterBean);

    /**
     * 登录失败返回的值
     */
    public void LoginFail();
}
