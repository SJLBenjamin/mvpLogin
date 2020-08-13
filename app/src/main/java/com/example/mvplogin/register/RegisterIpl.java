package com.example.mvplogin.register;

import com.example.mvplogin.bean.LoginAndRegisterBean;

/**
 * 注册回调接口,将model请求的数据提供给present
 */
public interface RegisterIpl {
    /**
     * @param loginAndRegisterBean 注册成功返回给p的值
     */
    public void registerSuccess(LoginAndRegisterBean loginAndRegisterBean);

    /**
     * 注册失败
     */
    public void registerFail();
}
