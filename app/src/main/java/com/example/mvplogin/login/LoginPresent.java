package com.example.mvplogin.login;

import com.example.mvplogin.bean.LoginAndRegisterBean;

/**
 * present持有view和model引用,将model和View解耦,通过p去操作
 */
public class LoginPresent implements LoginContract.LoginPresent {
    LoginContract.LoginView mLoginView;
    private final LoginModel mLoginModel;
    private final LoginIpl mLoginIpl;

    /**
     * @param loginView 获取view的引用
     */
    public LoginPresent(LoginContract.LoginView loginView){
        mLoginView = loginView;
        //创建model
        mLoginModel = new LoginModel();

        //创建登录回调接口
        mLoginIpl = new LoginIpl() {
            @Override
            public void LoginSuccess(LoginAndRegisterBean loginAndRegisterBean) {
                //调用view中的登录成功
                mLoginView.LoginSuccess(loginAndRegisterBean);
            }

            @Override
            public void LoginFail() {
                //调用view中的登录失败
                mLoginView.LoginFail();
            }
        };
    }

    /**
     * 登录
     * @param userName 登录用户名
     * @param password 登录密码
     */
    @Override
    public void login(String userName, String password) {
        //调用model中的登录,将mLoginIpl回调接口给model
        mLoginModel.login(userName,password,mLoginIpl);
    }


}
