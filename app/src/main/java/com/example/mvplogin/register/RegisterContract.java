package com.example.mvplogin.register;

import com.example.mvplogin.bean.LoginAndRegisterBean;

public interface RegisterContract {

    /**
     * 注册的present
     */
     interface RegisterPresent{
        /**
         * @param username 账号
         * @param password 密码
         * @param rePassword 确认密码
         */
        public void register(String username,String password,String rePassword);
    }

    /**
     * 注册的view
     */
    interface RegisterView{
        /**
         * 注册成功
         * @param loginAndRegisterBean 注册成功后返回给View的值
         */
        public void registerSuccess(LoginAndRegisterBean loginAndRegisterBean);

        /**
         * 注册失败
         */
        public void registerFail();
    }
}
