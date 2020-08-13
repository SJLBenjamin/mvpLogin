package com.example.mvplogin.login;

import com.example.mvplogin.bean.LoginAndRegisterBean;

/**
 * 契约类,包含了present和view
 */
public interface LoginContract {

    /**
     * present
     */
    interface LoginPresent{
        /**
         * 登录接口
         * @param userName 登录用户名
         * @param password  登录密码
         */
        public void login(String userName,String password);
    }

    /**
     * view
     */
    interface LoginView{
        /**
         * 登录成功
         * @param loginAndRegisterBean 登录成功返回给View的值
         */
        public void LoginSuccess(LoginAndRegisterBean loginAndRegisterBean);

        /**
         * 登录失败
         */
        public void LoginFail();
    }

}
